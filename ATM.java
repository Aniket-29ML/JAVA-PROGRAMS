import java.util.Scanner;

public class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Successfully deposited: Rs." + amount);
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("succesfully withdraw: Rs." + amount);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(1000);

        while (true) {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            try {
            
             int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                          atm.checkBalance();
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Operation completed.\n");
            }
        }    
    }
}
        

