package net.some.pack;

import java.util.Collection;


public class LocaleJoin extends JoinPart {
 
    private String idPart;

    /**
     * @param entity сущность, к которой происходит присоединение.
     * @param field поле, которое вызвало присоединение.
     */
    public LocaleJoin(Entity entity, EntityField field, String idPart) {
        super(entity, field);
        this.idPart = idPart;
    }

    @Override
    public String getSql(ExecutionContext ctx, Collection<ParameterBinding> bindings) {
        /* у нас есть три варианта развития событий для полей с локализацией. 
         *  
         * 1. У нас есть строка в требуемой локали.
         * 2. Нет строки в требуемой локали, но есть строка в default локали.
         * 3. Нет строки ни в требуемой локали, ни в default локали. 
         */

        String locale = ctx.getLocale();

        String tableAlias = LocaleJoin.getTableAlias(entity, field);
        
        bindings.add(new StringParameterBinding(
                new StringBuffer(tableAlias).append("_FIELD_NAME").toString(),
                field.getName()));

        bindings.add(new StringParameterBinding(
                new StringBuffer(tableAlias).append("_LOCALE").toString(),
                locale));

        return new StringBuffer("LEFT JOIN ")
                 .append(LocaleJoin.getTableName(entity)).append(" ")
                 .append(tableAlias).append(" ON ")
                 
                 .append(tableAlias).append(".ID = ").append(idPart).append(" AND ")

                 .append(tableAlias).append(".FIELD_NAME = :")
                 .append(tableAlias).append("_FIELD_NAME")
                 
                 .append(" AND ").append(tableAlias).append(".LOCALE = :")
                 .append(tableAlias).append("_LOCALE")
                 
                 .toString();
    }

    public static String getTableAlias(Entity entity, EntityField field){
        return new StringBuffer(entity.getTableName()).append("_")
                .append(field.getName()).append("_LOCALIZED").toString();
    }
    
    public static String getTableName(Entity entity){
        return new StringBuffer(entity.getTableName()).append("_LOCALIZED").toString();
    }
}
