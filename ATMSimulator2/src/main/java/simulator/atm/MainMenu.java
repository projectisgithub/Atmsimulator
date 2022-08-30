package simulator.atm;

import java.util.Scanner;

public class MainMenu {

	public MainMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void welcome() {
		System.out.println("*****************************Welcome to ATM Simulation*************************************");
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to Create Account"
				+ "         Enter 2 to Log In");
		int a = sc.nextInt();
		if(a==1) {
			SignInDB si=new SignInDB(a);
			TransacTion ti = new TransacTion();
			ti.printUserMenu();
			
			}
		else if(a==2) {
			LogIn li = new LogIn();
			TransacTion ti = new TransacTion();
			ti.printUserMenu();
			
		}
		else {
			System.out.println("Please select valid option.");
			run();
			
		}
	}
}
