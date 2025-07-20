package net.some.pack;

import java.util.Collection;

@Getter
@Setter
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

    public String accept(Visitor visitor, ExecutionContext ctx, Collection<ParameterBinding> bindings) {
        return visitor.visit(ctx, bindings, this);
    }

}
