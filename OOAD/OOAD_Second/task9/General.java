package OOAD_Second.task9;

import java.io.Serializable;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Класс неявно наследуется от универсального базового Object.
public class General implements Cloneable, Serializable {

    public <T> void deepCopyTo(T gen) {
        gen = deserialize(serialize(this));
    }

    public <T> T deepClone() {
        return deserialize(serialize(this));
    }

    public boolean equals(General gen) {
        return super.equals(gen);
    }

    public <T> String serialize(T obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T deserialize(String obj) {
        try {
            return new ObjectMapper().readValue(obj, this.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean isType(Class<?> type) {
        return type.isInstance(this);
    }

    public Class<?> getRealType() {
        return this.getClass();
    }
}

class Any extends General {

}
