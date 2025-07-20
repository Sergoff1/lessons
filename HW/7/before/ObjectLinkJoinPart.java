package net.some.pack;

import java.util.Collection;

public class ObjectLinkJoinPart extends JoinPart {

    /**
     * @param entity сущность, к которой происходит присоединение.
     * @param field поле, которое вызвало присоединение.
     */
    public ObjectLinkJoinPart(Entity entity, EntityField field) {
        super(entity, field);
    }

    @Override
    public String getSql(ExecutionContext ctx, Collection<ParameterBinding> bindings) {


        if (field.getType() != EntityField.Type.OL_LOOKUP) {
            return "";
        }

        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        StringBuilder sb = new StringBuilder("JOIN OBJECT_LINK ");

        Entity linkedEntity = ctx.getModel().getEntity(field.getRefEntityName());

        String olName = SynonymHelper.limitString("ol" + linkedEntity.getName());

        sb.append(specSymbol)
                .append(olName)
                .append(specSymbol)
                .append(" ON ").append(specSymbol).append(olName).append(specSymbol).append(".");
        if (field.getLinkEntityType().equalsIgnoreCase(EntityField.CHILD)) {
            sb.append("parent_id");
        } else {
            sb.append("child_id");
        }

        sb.append(" = ")
                .append(specSymbol).append(SynonymHelper.limitString(entity.getName())).append(specSymbol)
                .append(".ID")
                .append(" JOIN ")
                 .append(specSymbol).append(linkedEntity.getTableName()).append(specSymbol)
                .append(" ")
                .append(specSymbol).append(SynonymHelper.limitString(linkedEntity.getName())).append(specSymbol)
                .append(" ON ")
                .append(specSymbol).append(SynonymHelper.limitString(linkedEntity.getName())).append(specSymbol)
                .append(".ID = ")
                .append(specSymbol).append(olName).append(specSymbol)   .append(".");
        if (field.getLinkEntityType().equalsIgnoreCase(EntityField.CHILD)) {
            sb.append("child_id");
        } else {
            sb.append("parent_id");
        }

        String varName = "D_" + olName;
        sb.append(" and ").append(specSymbol).append(olName).append(specSymbol).append(".discriminator = :")
            .append(varName);

        bindings.add(new StringParameterBinding(varName, field.getLinkName().toUpperCase()));

        return sb.toString();
    }

}
