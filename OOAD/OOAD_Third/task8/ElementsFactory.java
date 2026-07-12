package OOAD_Third.task8;

public abstract class ElementsFactory {

    //Конструкторы
    //постусловие: создана фабрика элементов
    //public ElementsFactory ElementsFactory();

    //Запросы

    //предусловие: в комбинации содержится больше трёх элементов
    public abstract Element createSpecialElement(List<Coordinate> combination);

    public abstract Element createRandomPlainElement();
}
