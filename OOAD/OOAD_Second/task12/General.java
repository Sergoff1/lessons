package OOAD_Second.task12;

public class General {

    public static <T, S> T assignment_attempt(T target, S source) {
        if (target.getClass().isAssignableFrom(source.getClass())) {
            return (T) source;
        }
        return (T) new None();
    }
}

class Any extends General {

}

final class None extends Any {

}
