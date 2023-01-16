import java.util.Scanner;
public class ATM {
    private static boolean isLoggedIn = false;

    public static void displayMenu() {

        System.out.println("0 - create user");
        System.out.println("1 - login");
        System.out.println("2 - withdraw");
        System.out.println("3 - deposit");
        System.out.println("4 - logout");

    }

    public static void main(String[] args) {
        String pin = null;
        app1 bank = new app1();

        bank.addUser("Bob",
                "1234 Bobby villa",
                500,
                "12345");

        bank.addUser("Bob",
                "1234 Bobby villa",
                500,
                "12345");

        bank.addUser("Bob",
                "1234 Bobby villa",
                500,
                "12345");
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0: {
                    System.out.print("Enter you name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter your address: ");
                    String address = scanner.nextLine();

                    System.out.println("Money to deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter your pin: ");
                    pin = scanner.next();


                    bank.addUser(name, address, amount, pin);
                }
                break;
                case 1: {
                    System.out.println("Enter your name: ");
                    String name = scanner.nextLine();

                    if (bank.login(name, pin)) {
                        isLoggedIn = true;
                    }
                }
                break;
                case 2: {
                    if (isLoggedIn) {
                        System.out.println("Withdraw amount:$ ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        double result = bank.withdraw(amount);
                        if (result < 0) {
                            System.out.println("Not enough money in your account.");
                        } else {
                            System.out.println("Withdrawal successful" + amount);
                        }
                    } else {
                        System.out.println("You must be logged in!");
                    }
                }
                break;
                case 3: {
                    if (isLoggedIn) {
                        System.out.println("Enter a amount to deposit: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        bank.deposit(amount);
                        System.out.println("Deposited successful" + amount);
                    } else {
                        System.out.println("You must be logged in!");
                    }
                }
                break;
                case 4: {
                    bank.logout();
                    isLoggedIn = false;
                    System.out.println("logged out.");
                }
                break;

                default: {
                    System.out.println("Not a valid input.");
                }
            } break;
        }
    }
}
