package SD_First.task1;

public class Example {
    public static void main(String[] args) {
        Storage dbStorage = new DatabaseStorage();

        dbStorage.save("Сведения о приросте поголовья скота");
        dbStorage.save("Содержание сна собаки");
        dbStorage.save("Текст со скрытым смыслом");

        System.out.println(dbStorage.retrieve(1));
        System.out.println(dbStorage.retrieve(2));
        System.out.println(dbStorage.retrieve(3));
    }
}
