package OOAD_Third.task8;

public abstract class EventManager {

    //Конструктор
    //постусловие: создана структура для хранения подписчиков и типов событий, на которые они будут подписываться
    //public EventManager(String... eventTypes);

    //Команды

    //предусловие: событие с этим типом существует в данном издателе
    //постусловие: новый подписчик связан с соответствующей темой
    public abstract void subscribe(String eventType, EventListener listener);

    //предусловие: подписчик наблюдает за указанной темой
    //постусловие: подписчик прекратил наблюдение
    public abstract void unsubscribe(String eventType, EventListener listener);

    public abstract void notify(String eventType, GameContext context);

}
