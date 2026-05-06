В java можно использовать ключевое слово final для запрета на переопределение метода в потомках.

```java
public class General implements Cloneable, Serializable {

    //Добавили ключевое слово final к объявлению метода, тем самым запретили его переопределять.
    public final <T> void deepCopyTo(T gen) {
        //logic
    }
    //...
}

public class Any extends General {
    
    @Override
    public final <T> void deepCopyTo(T gen) {
        // Получаем ошибку компиляции.
    } 
    
}
```