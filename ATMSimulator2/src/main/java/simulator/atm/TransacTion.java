 package simulator.atm;

import java.util.Date;
import java.util.Scanner;









public class TransacTion {
	Scanner sc = new Scanner(System.in);
	static TransacTion t=new TransacTion();
	SignIn si=new SignIn();
	static String  cardId;
	Date timeStamp=new Date();
	String d="deposit";
	String d2="withdraw";
	String d3="transfer";
   
	public void printUserMenu() {
		SignIn stud;
		
		
		int choice;
		 
		 
		do {
			System.out.println();
			
			System.out.printf("Choose your transaction type : ");
			System.out.println();
			System.out.println();
			System.out.printf("\n 1)Balance Enquiry");
			System.out.printf("    2) Withdraw");
			System.out.println();
			System.out.println();
			System.out.printf("\n 3) Deposit");
			System.out.printf("           4) Transfer");
			System.out.println();
			System.out.println();
			System.out.printf("\n 5)Mini statments");
			
			System.out.printf("     6)Pin Change");
			System.out.println();
			System.out.println();
			System.out.printf("\n          \t7)Quit");
			System.out.println();
			System.out.println();
			System.out.println("\nEnter Transaction Number : ");
			choice=sc.nextInt();
			if (choice<1 || choice>7) {
				System.out.println("Invalid input."+" Please choose an option between 1-7.");
				
			}
			
		} while (choice<1 || choice>7);
		 
		 
		
		switch (choice) {
		case 1:
			System.out.println();
			balEnquiry();
			
			break;
		case 2:
			System.out.println();
			withdraw();
			break;
		case 3:
			System.out.println();
				deposit();
				break;
		case 4:
			System.out.println();
				transfer();
				break;
		case 5:
			System.out.println();
			showTransaction()	;	
			break;
		case 6:
			System.out.println();
			pinChange();
		case 7:
			System.exit(0)	;	
			break;
		default:
			System.out.println("Please select valid entry.");
			printUserMenu();
		}
		System.out.println("Thank you");
		
	}
private void showTransaction() {
		// get data from trans database
	//give it trans card id
		//
	LogIn l=new LogIn(1.0);
	l.trans();
	}
public void LogIn1() {
		String pin;
		System.out.println("Enter Card ID: ");
		cardId = sc.next();
		System.out.println("Enter pin:");
		pin = sc.next();
		LogIn logIn=new LogIn(cardId, pin); 
		logIn.verify(cardId);
		
		//Verify cardId and pin from database
	}
	
	
	public void balEnquiry() {
		System.out.println("your balance is...");
		System.out.println(LogIn.getbalance());
//		MainMenu mm = new MainMenu();
//		mm.run();
		//LogIn l =new LogIn(1.0);
		//l.getBal();


	}
	
	public void pinChange() {
		System.out.println("Enter old pin");
		String opin=sc.next();
		LogIn.chechPin(opin);
	}
//	private  void showTransaction(SignIn signIn) {
//		// TODO Auto-generated method stub
//		int theact; 
//		
//		do {
//			System.out.printf("Enter the number (1-%d) of the account\n whose transaction "
//					+ "you want to see: ",signIn.numberofaccounts());
//			theact=sc.nextInt();
//			if (theact<0 || theact>signIn.numberofaccounts()) {
//				System.out.println("Invailed account.please try again");
//				
//			}
//			
//		} while (theact<0 || theact>theUser.numberofaccounts()); 
//		theUser.printAccontHistory(theact);
//		
//	}

	public void withdraw() {
	//	SignIn si=new SignIn();
		System.out.println("Enter amount you want to withdraw: ");
		double with = sc.nextDouble();
		
		LogIn l=new LogIn(1.0);
		l.withBal(with);
//		LogIn.balance=(LogIn.getbalance()-with);
//		System.out.println("Please collect your cash.");
//		System.out.println("Current balance = "+LogIn.getbalance());
		String name=LogIn.getFirstname();
		System.out.println(name);
		Trans trans=new Trans(TransacTion.cardId,name,timeStamp,with,d2);
		trans.addTransactions(TransacTion.cardId,name,timeStamp,with,d2); 
	}
	public void transfer() {
		String name=LogIn.getFirstname();
		System.out.println(name);
		System.out.println("Enter amount: ");
		double with = sc.nextDouble();
		System.out.println("Enter accoun number of beneficiery : ");
		String acNo=sc.next();
		LogIn l=new LogIn(1.0);
		l.transferBal(with,acNo);
		Trans trans=new Trans(TransacTion.cardId,name,timeStamp,with,d);
		trans.addTransactions(TransacTion.cardId,name,timeStamp,with,d);
	}
	public void deposit() {
		String name=LogIn.getFirstname();
		//System.out.println(name);
		System.out.println("Enter amount you want to deposit: ");
		double with = sc.nextDouble();
		//si.setBalance();
		LogIn l=new LogIn(1.0);
		l.depBal(with);
//		System.out.println("Amount deposited succesfully");
//		System.out.println("Current balance = "+LogIn.getbalance());
//		//trans.ShowTransactionHistory(cardId);
		
		Trans trans=new Trans(TransacTion.cardId,name,timeStamp,with,d);
		trans.addTransactions(TransacTion.cardId,name,timeStamp,with,d); 
	}
	
}