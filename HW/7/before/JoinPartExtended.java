package net.some.pack;

import java.util.Collection;

public class JoinPartExtended extends JoinPart {

    /**
     * @param entity сущность, к которой происходит присоединение.
     * @param field поле, которое вызвало присоединение.
     */
    public JoinPartExtended(Entity entity, EntityField field) {
        super(entity, field);
    }

    @Override
    public String getSql(ExecutionContext ctx, Collection<ParameterBinding> bindings) {

        if (field.getType() == EntityField.Type.REVERSE_LOOKUP) {
            return "";
        }
        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        StringBuilder sb = new StringBuilder(field.isMandatory() ? "JOIN " : "LEFT JOIN ")
                .append(specSymbol)
                .append(ctx.getModel().getEntity(field.getRefEntityName()).getTableName())
                .append(specSymbol)
                .append(" ").append(specSymbol).append(field.getName()).append(specSymbol)
                .append(" ON ")
                .append(specSymbol).append(SynonymHelper.limitString(entity.getName())).append(specSymbol);
        if (field.getType() == EntityField.Type.REVERSE_LOOKUP) {
            sb.append(".ID");
        } else {
            sb.append(".").append(field.getColumnName());
        }

        sb.append(" = ").append(specSymbol).append(field.getName()).append(specSymbol);

        if (field.getType() == EntityField.Type.REVERSE_LOOKUP) {
            sb.append(".").append(field.getColumnName());
        } else {
            sb.append(".ID");
        }

        return sb.toString();
    }

}
