package net.some.pack;

import java.util.Collection;

public class JoinPart {

    protected Entity entity;
    protected Entity refEntity;
    protected EntityField field;
    protected String entSyn;

    /**
     * @param entity сущность, к которой происходит присоединение.
     * @param field поле, которое вызвало присоединение.
     */
    public JoinPart(Entity entity, EntityField field) {
        this.entity = entity;
        this.field = field;
    }

    public JoinPart(Entity entity, Entity refEntity,  EntityField field, String entSyn) {
        this.entity = entity;
        this.refEntity = refEntity;
        this.field = field;
        this.entSyn = entSyn;
    }

    public String getSql(ExecutionContext ctx, Collection<ParameterBinding> bindings) {
        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        Entity refEntity = this.refEntity != null ?  this.refEntity  : ctx.getModel().getEntity(field.getRefEntityName());

        String firstTableAlias = new StringBuilder().append(entSyn != null ? entSyn + "_"  : "").append(field.getName()).toString();
        String secondTableAlias = new StringBuilder().append(entSyn != null ? entSyn : entity.getName()).toString();

        String firstTableAlias_limited = (SynonymHelper.limitString(firstTableAlias));
        String secondTableAlias_limited = (SynonymHelper.limitString(secondTableAlias));


        return new StringBuffer(field.isMandatory() ? "JOIN " : "LEFT JOIN ")

                .append(specSymbol)
                .append(refEntity.getTableName())
                .append(specSymbol)

                .append(" ")

                .append(specSymbol)
                .append(firstTableAlias_limited)
                .append(specSymbol)

                .append(" ON ")

                .append(specSymbol)
                .append(secondTableAlias_limited)
                .append(specSymbol)
                .append(".").append(field.getColumnName())

                .append(" = ")

                .append(specSymbol)
                .append(firstTableAlias_limited)
                .append(specSymbol)
                .append(".").append(refEntity.getField(field.getRefEntityFieldName()).getColumnName()).toString();
    }

}
