package net.some.pack;

import java.util.Collection;

@Getter
@Setter
public class ObjectLinkJoinPart extends JoinPart {

    /**
     * @param entity сущность, к которой происходит присоединение.
     * @param field поле, которое вызвало присоединение.
     */
    public ObjectLinkJoinPart(Entity entity, EntityField field) {
        super(entity, field);
    }

    @Override
    public String accept(Visitor visitor, ExecutionContext ctx, Collection<ParameterBinding> bindings) {
        return visitor.visit(ctx, bindings, this);
    }

}
