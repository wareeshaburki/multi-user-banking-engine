import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    String cnic;
    int age;
    String accountType;
    double balance = 15000.00;

    public User(String name, String cnic, int age, String accountType) {
        this.name = name;
        this.cnic = cnic;
        this.age = age;
        this.accountType = accountType;
    }
}

class Account {

    public void deposit(double amount, User mainUser) {
        mainUser.balance += amount;
        System.out.println("Deposit Successful");
    }

    public void withdraw(double amount, User mainUser) {
        if (amount > mainUser.balance) {
            System.out.println("No sufficient amount in the account");
            return;
        }
        mainUser.balance = mainUser.balance - amount;
        System.out.println("Withdraw Successful");
    }

    public void checkBalance(User mainUser) {
        System.out.println(mainUser.balance);
    }

    public void transfer(User user, double amount, User mainUser) {
        if (amount > mainUser.balance) {
            System.out.println("No sufficient amount in the account");
            return;
        }
        user.balance = user.balance + amount;
        mainUser.balance -= amount;
        System.out.println("Transaction Successful");
    }
}

public class TheMultiUserBankingEngine {
    public void menu() {
        System.out.println();
        System.out.println("1. Register a user");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Check Amount");
        System.out.println("5. Transfer Money");
        System.out.println();
        System.out.print("Enter your choice : ");
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        String exitChoice;
        int choice;
        Scanner sc = new Scanner(System.in);
        TheMultiUserBankingEngine atm = new TheMultiUserBankingEngine();
        Account account = new Account();
        double amount;
        String cnic;
        do {
            atm.menu();
            boolean found = false;
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        String name;
                        int age;
                        sc.nextLine();
                        String accountType;
                        System.out.print("Enter the name of the user: ");
                        name = sc.nextLine();
                        System.out.print("Enter CNIC : ");
                        cnic = sc.nextLine();
                        for (int i = 0; i < users.size(); i++) {
                            if (cnic.equals(users.get(i).cnic)) {
                                System.out.println("CNIC already exists");
                                break;
                            }
                        }
                        System.out.print("Enter age : ");
                        age = sc.nextInt();
                        if (age < 18) {
                            System.out.println("user can not be registered");
                            break;
                        }
                        sc.nextLine();
                        System.out.print("Enter account type (Savings,Current) : ");
                        accountType = sc.nextLine();
                        User user = new User(name, cnic, age, accountType);
                        users.add(user);
                        System.out.println("User added successfully");
                        break;

                    case 2:
                        System.out.print("Enter cnic : ");
                        cnic = sc.nextLine();
                        for (User person : users) {
                            if (cnic.equals(person.cnic)) {
                                System.out.print("Enter amount to deposit : ");
                                amount = sc.nextDouble();
                                sc.nextLine();
                                account.deposit(amount, person);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("User not found");
                        }
                        break;
                    case 3:
                        System.out.print("Enter cnic : ");
                        cnic = sc.nextLine();
                        for (User person : users) {
                            if (cnic.equals(person.cnic)) {
                                System.out.print("Enter amount to withdraw : ");
                                amount = sc.nextDouble();
                                sc.nextLine();
                                account.withdraw(amount, person);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("User not found");
                        }
                        break;
                    case 4:
                        System.out.print("Enter cnic : ");
                        cnic = sc.nextLine();
                        for (User person : users) {
                            if (cnic.equals(person.cnic)) {
                                account.checkBalance(person);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("User not found");
                        }
                        break;
                    case 5:
                        System.out.print("Enter your cnic : ");
                        cnic = sc.nextLine();
                        System.out.print("Enter amount to transfer : ");
                        amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter cnic to which you want to transfer money : ");
                        String userCnic;
                        userCnic = sc.nextLine();
                        for (User person : users) {
                            if (cnic.equals(person.cnic)) {
                                for (User person2 : users) {
                                    if (userCnic.equals(person2.cnic)) {
                                        account.transfer(person2, amount, person);
                                        break;
                                    }
                                }
                                System.out.println("User not found");
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("User not found");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (Exception e) {
                System.out.println("Enter number as a choice only");
                sc.nextLine();
            }
            sc.nextLine();
            System.out.print("Do you want to use ATM again (y/n) : ");
            exitChoice = sc.next();

        } while (exitChoice.equals("y") || exitChoice.equals("Y"));
    }
}
