package net.some.pack;

import java.util.Collection;

@Getter
@Setter
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

    public String accept(Visitor visitor, ExecutionContext ctx, Collection<ParameterBinding> bindings) {
        return visitor.visit(ctx, bindings, this);
    }

    public static String getTableAlias(Entity entity, EntityField field){
        return new StringBuffer(entity.getTableName()).append("_")
                .append(field.getName()).append("_LOCALIZED").toString();
    }
    
    public static String getTableName(Entity entity){
        return new StringBuffer(entity.getTableName()).append("_LOCALIZED").toString();
    }
}
