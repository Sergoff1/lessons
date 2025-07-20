package net.some.pack;

import java.util.Collection;

public class GetJoinPartVisitor implements Visitor {

    @Override
    public String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, JoinPart sj) {
        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        Entity refEntity = sj.refEntity != null ?  sj.refEntity  : ctx.getModel().getEntity(sj.getField().getRefEntityName());

        String firstTableAlias = new StringBuilder().append(sj.getEntSyn() != null ? sj.getEntSyn() + "_"  : "").append(sj.getField().getName()).toString();
        String secondTableAlias = new StringBuilder().append(sj.getEntSyn() != null ? sj.getEntSyn() : sj.getEntity().getName()).toString();

        String firstTableAlias_limited = (SynonymHelper.limitString(firstTableAlias));
        String secondTableAlias_limited = (SynonymHelper.limitString(secondTableAlias));


        return new StringBuffer(sj.getField().isMandatory() ? "JOIN " : "LEFT JOIN ")

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
                .append(".").append(sj.getField().getColumnName())

                .append(" = ")

                .append(specSymbol)
                .append(firstTableAlias_limited)
                .append(specSymbol)
                .append(".").append(refEntity.getField(sj.getField().getRefEntityFieldName()).getColumnName()).toString();
    }

    @Override
    public String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, LocaleJoin lj) {
        String locale = ctx.getLocale();

        String tableAlias = LocaleJoin.getTableAlias(lj.getEntity(), lj.getField());

        bindings.add(new StringParameterBinding(
                new StringBuffer(tableAlias).append("_FIELD_NAME").toString(),
                lj.getField().getName()));

        bindings.add(new StringParameterBinding(
                new StringBuffer(tableAlias).append("_LOCALE").toString(),
                locale));

        return new StringBuffer("LEFT JOIN ")
                .append(LocaleJoin.getTableName(lj.getEntity())).append(" ")
                .append(tableAlias).append(" ON ")

                .append(tableAlias).append(".ID = ").append(lj.getIdPart()).append(" AND ")

                .append(tableAlias).append(".FIELD_NAME = :")
                .append(tableAlias).append("_FIELD_NAME")

                .append(" AND ").append(tableAlias).append(".LOCALE = :")
                .append(tableAlias).append("_LOCALE")

                .toString();
    }

    @Override
    public String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, JoinPartExtended jpe) {
        if (jpe.getField().getType() == EntityField.Type.REVERSE_LOOKUP) {
            return "";
        }
        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        StringBuilder sb = new StringBuilder(jpe.getField().isMandatory() ? "JOIN " : "LEFT JOIN ")
                .append(specSymbol)
                .append(ctx.getModel().getEntity(jpe.getField().getRefEntityName()).getTableName())
                .append(specSymbol)
                .append(" ").append(specSymbol).append(jpe.getField().getName()).append(specSymbol)
                .append(" ON ")
                .append(specSymbol).append(SynonymHelper.limitString(jpe.getEntity().getName())).append(specSymbol);
        if (jpe.getField().getType() == EntityField.Type.REVERSE_LOOKUP) {
            sb.append(".ID");
        } else {
            sb.append(".").append(jpe.getField().getColumnName());
        }

        sb.append(" = ").append(specSymbol).append(jpe.getField().getName()).append(specSymbol);

        if (jpe.getField().getType() == EntityField.Type.REVERSE_LOOKUP) {
            sb.append(".").append(jpe.getField().getColumnName());
        } else {
            sb.append(".ID");
        }

        return sb.toString();
    }

    @Override
    public String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, ObjectLinkJoinPart olj) {
        if (olj.getField().getType() != EntityField.Type.OL_LOOKUP) {
            return "";
        }

        char specSymbol = DBMSHelper.getInstance().getSpecSymbol();
        StringBuilder sb = new StringBuilder("JOIN OBJECT_LINK ");

        Entity linkedEntity = ctx.getModel().getEntity(olj.getField().getRefEntityName());

        String olName = SynonymHelper.limitString("ol" + linkedEntity.getName());

        sb.append(specSymbol)
                .append(olName)
                .append(specSymbol)
                .append(" ON ").append(specSymbol).append(olName).append(specSymbol).append(".");
        if (olj.getField().getLinkEntityType().equalsIgnoreCase(EntityField.CHILD)) {
            sb.append("parent_id");
        } else {
            sb.append("child_id");
        }

        sb.append(" = ")
                .append(specSymbol).append(SynonymHelper.limitString(olj.getField().getName())).append(specSymbol)
                .append(".ID")
                .append(" JOIN ")
                .append(specSymbol).append(linkedEntity.getTableName()).append(specSymbol)
                .append(" ")
                .append(specSymbol).append(SynonymHelper.limitString(linkedEntity.getName())).append(specSymbol)
                .append(" ON ")
                .append(specSymbol).append(SynonymHelper.limitString(linkedEntity.getName())).append(specSymbol)
                .append(".ID = ")
                .append(specSymbol).append(olName).append(specSymbol)   .append(".");
        if (olj.getField().getLinkEntityType().equalsIgnoreCase(EntityField.CHILD)) {
            sb.append("child_id");
        } else {
            sb.append("parent_id");
        }

        String varName = "D_" + olName;
        sb.append(" and ").append(specSymbol).append(olName).append(specSymbol).append(".discriminator = :")
                .append(varName);

        bindings.add(new StringParameterBinding(varName, olj.getField().getLinkName().toUpperCase()));

        return sb.toString();
    }
}
