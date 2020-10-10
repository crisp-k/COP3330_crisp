import java.util.Scanner;

public class AccountTest2 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.54);

        System.out.printf("%s balance: $%.2f\n",account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f\n",account2.getName(), account2.getBalance());

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();

        System.out.printf("Adding $%.2f to account1\n", depositAmount);
        account1.deposit(depositAmount);

        System.out.printf("%s balance: $%.2f\n",account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f\n",account2.getName(), account2.getBalance());

        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();

        System.out.printf("Adding $%.2f to account2\n", depositAmount);
        account2.deposit(depositAmount);

        System.out.printf("%s balance: $%.2f\n",account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f\n",account2.getName(), account2.getBalance());
    }
}
