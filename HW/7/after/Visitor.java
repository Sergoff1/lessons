package net.some.pack;

import java.util.Collection;

public interface Visitor {

    String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, JoinPart sj);

    String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, LocaleJoin lj);

    String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, JoinPartExtended jpe);

    String visit(ExecutionContext ctx, Collection<ParameterBinding> bindings, ObjectLinkJoinPart olj);
}
