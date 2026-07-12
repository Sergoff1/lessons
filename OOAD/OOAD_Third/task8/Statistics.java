package OOAD_Third.task8;

public abstract class Statistics {

    //Конструкторы
    //постусловие: создана структура статистики с пустой историей ходов и нулевым счётом
    //public Statistics Statistics();

    //Команды

    //предусловие: переданное значение больше ноля
    //постусловие: значение счёта увеличено на переданное количество баллов
    public abstract void increaseScore(int amount);

    //постусловие: ход сохранён в истории
    public abstract void saveMove(Coordinate first, Coordinate second);

    //Запросы
    public abstract int getScore();

    public abstract int getMoveCount();

    public abstract MoveHistory getMoveHistory();

}
