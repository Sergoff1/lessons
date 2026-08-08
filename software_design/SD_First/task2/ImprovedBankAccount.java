package SD_First.task2;

public class ImprovedBankAccount {

    private double balance;

    public ImprovedBankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Нельзя внести отрицательную сумму.");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Нельзя снять отрицательную сумму.");
            return;
        }

        if (balance < amount) {
            System.out.println("На счёте недостаточно средств.");
            return;
        }

        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}
