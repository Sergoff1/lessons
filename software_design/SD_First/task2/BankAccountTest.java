package SD_First.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(1000d);
    }

    @Test
    void bankAccountTest() {
        System.out.println("Начальный баланс: " + bankAccount.getBalance());

        bankAccount.deposit(500);
        System.out.println("Положили 500: " + bankAccount.getBalance());

        bankAccount.deposit(-500);
        System.out.println("Положили -500: " + bankAccount.getBalance());

        bankAccount.withdraw(1200);
        System.out.println("Сняли 1200: " + bankAccount.getBalance());

        bankAccount.withdraw(-500);
        System.out.println("Сняли -500: " + bankAccount.getBalance());
    }
}
