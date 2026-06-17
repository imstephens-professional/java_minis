package bankSource;
/*
 * Author: Isabella Stephens
 * Created: 10 June 2026
 * Updated: 17 June 2026
 * 
 * Description: A prototype of the full version of the Bank Account application.
 */

// imports
import java.util.Scanner;
import java.math.BigDecimal; // BigDecimal is best for financial calculations
import java.util.Random;
import java.util.ArrayList;

public class BankingApplication {
	static boolean contApp = true; // determines whether the user wants to continue the application or not
	static String userAccess; // what user types in to access their account
	static String userChoice; // what option the user selects when logged into the app
	static double moneyManip = 0.00;
	static int userIDInsert; // the user attempts to access their ID via pin #
	static ArrayList<BankAccount> accountHolder = new ArrayList<BankAccount>();
	static BankAccount user; // who the user currently is

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount test1 = new BankAccount("Johnny", "Bravo");
		BankAccount test2 = new BankAccount("Matilda", "Ferro");
		BankAccount test3 = new BankAccount("James", "Bond");
		BankAccount test4 = new BankAccount("Buffy", "Slayer");
		BankAccount test5 = new BankAccount("Charlie", "Smith");
		test2.quickPrint();
		accountHolder.add(test1);
		accountHolder.add(test2);
		accountHolder.add(test3);
		accountHolder.add(test4);
		accountHolder.add(test5);

		// user signs into account or creates account
		checkSignIn(sc);

		// user has signed into the application
		while (contApp == true) {
			System.out.println("What do you want to do?");
			System.out.println("1=Deposit, 2=Withdraw, 3=See Balance, 4=See ID, 5=See Name, 6=Change Name, 7=Quit");
			userChoice = sc.next();

			switch (userChoice) {
			case "1":
				System.out.println("How much do you want to deposit in your account?");
				moneyManip = sc.nextDouble();
				user.deposit(moneyManip);
				break;
			case "2":
				System.out.println("How much do you want to withdraw from your account?");
				moneyManip = sc.nextDouble();
				user.withdraw(moneyManip);
				break;
			case "3":
				user.getUserBalance();
				break;
			case "4":
				System.out.println("Please type in your pin to access ID.");
				userIDInsert = sc.nextInt();
				int temp1 = user.getUserID(userIDInsert);
				if (temp1 < 0) {
					System.out.println("Wrong pin.");
				} else {
					System.out.println("Your ID is " + temp1);
				}
				break;
			case "5":
				user.getUserName();
				break;
			case "6":
				System.out.println("What is your new first name?");
				String temp3 = sc.next();
				System.out.println("What is your new last name?");
				String temp4 = sc.next();
				user.setName(temp3, temp4);
				break;
			case "7":
				contApp = false;
				break;
			default:
				System.out.println("ERROR: Try again.");
			}
		}

		sc.close();
	} // end of main

	// checks to see if the user wants to sign into the
	public static void checkSignIn(Scanner sc) {
		boolean flagCheckOver = false;

		while (flagCheckOver == false) {
			System.out.println("Please type in your pin to access your account. Otherwise, type 'Create'.");
			userAccess = sc.next();

			switch (userAccess) {
			case "Create", "create":
				System.out.println("What is your first name?");
				String usFirst = sc.next();
				System.out.println("What is your last name?");
				String usLast = sc.next();
				user = new BankAccount(usFirst, usLast);
				user.quickPrint();
				accountHolder.add(user); // only add to list here bc it presumes that user already had an account before
											// then
				break;
			default:
				// checks all the users in the "database"
				for (int i = 0; i < accountHolder.size(); i++) {
					BankAccount temp = accountHolder.get(i);
					int accountPin = temp.getUserPin();

					if (accountPin == Integer.parseInt(userAccess)) {
						user = temp;
						flagCheckOver = true;
					} 
				}

			} // end of switch
			
			if(flagCheckOver==false) {
				System.out.println("Incorrect pin.");
			}
		}
	}

} // end of BankingApplication

/*
 * Creates a bank account object.
 */
class BankAccount {
	private int userID; // user ID - completely unique to the user & cannot be changed
	private int userPin; // user pin - must be used to access the account
	private String firstName; // user first name - can be repeated, must be used to access the account
	private String lastName; // user last name - can be repeated, must be used to access the account; can
								// include middle name
	private BigDecimal userBalance; // current balance

	// create a bank account
	public BankAccount(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userBalance = new BigDecimal("0.00");

		Random r = new Random();

		// create userPin - should have 6 nums
		this.userPin = r.nextInt((999999 - 100000) + 1) + 100000;

		// create userID - should have 9 nums - DOES NOT CHECK TO SEE IF IT MATCHES
		// OTHER IDs
		this.userID = r.nextInt((999999999 - 100000000) + 1) + 100000000;
	}

	// do not use in final version
	void quickPrint() {
		System.out.println(userID + " " + userPin + " " + firstName + " " + lastName + " $" + userBalance);
	}

	void deposit(double newMoney) {
		BigDecimal safeConv = frmDbleConv(newMoney);
		this.userBalance.add(safeConv);
	}

	BigDecimal withdraw(double getRidOf) {
		BigDecimal safelyConv = frmDbleConv(getRidOf);
		userBalance.subtract(safelyConv);
		return userBalance;
	}

	void getUserBalance() {
		System.out.println("Your balance is $" + userBalance);
	}

	int getUserID(int typedPin) {
		if (typedPin == userPin) {
			return userID;
		} else {
			return -1;
		}
	}

	int getUserPin() {
		return userPin;
	}

	void getUserName() {
		System.out.println(firstName + " " + lastName);
	}

	void setName(String userFirst, String userLast) {
		firstName = userFirst;
		lastName = userLast;

		System.out.println("Name changed to " + firstName + " " + lastName);
	}

	// converts double values into BigDecimal
	BigDecimal frmDbleConv(double temp) {
		BigDecimal fromDouble = BigDecimal.valueOf(temp);
		return fromDouble;
	}

} // end of BankAccount