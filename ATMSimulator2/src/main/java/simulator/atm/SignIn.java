package simulator.atm;
/*
 * write code to save new user in database
 * write code to direct towards transaction/welcome page
 */


import java.util.Random;
import java.util.Scanner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="SignIn_Info")
public class SignIn {
	@Id
	private String cardId="";
	private String firstName="";
	private String secondName="";
	private String surname="";
	private String gender="";
	private String address="";
	private int age;
	private long phoneNo;
	private String pin="";
	private double balance;
	private String accountNo="";
	
	@Transient
	Scanner sc=new Scanner(System.in);
	@Transient	
	Random ran=new Random();	
	
	public SignIn() {
		
		
		
		}
	
	public SignIn(int i) {
		System.out.println("Enter first name:");
		this.firstName= sc.next();
		System.out.println("Enter middle name:");
		this.secondName = sc.next();
		System.out.println("Enter surname:");
		this.surname = sc.next();
		System.out.println("Enter gender:");
		this.gender = sc.next();
		System.out.println("Enter city:");
		this.address = sc.next();
		System.out.println("Enter age:");
		this.age = sc.nextInt();
		System.out.println("Enter Phone number");
		this.phoneNo = sc.nextLong();
		generateCardId();
		//System.out.println(this.cardId);
		generatePin();
		generateAccountNumber();
		//System.out.println(this.pin);
		
		do{
			System.out.println("Please deposit minimum 1000 to open account: ");
			Double dep=sc.nextDouble();
			this.balance=LogIn.balance+dep;
		}while(this.balance<1000);
		
		
		System.out.println("New user with name "+firstName + " " + surname+" created.");
		System.out.println("Please note your Card Id and pin for further transactions");
		System.out.println("Card Id: "+this.cardId +"     Pin: "+this.pin);
		System.out.println("Current balance = "+this.balance);
		}

	
	public double getBalance() {
		return balance;
	}
	

	public void setBalance(double balance) {
		this.balance=balance;
	}

	public String generateCardId() {
		cardId="";
		for(int i=0;i<=5;i++) {
			   this.cardId+=((Integer)ran.nextInt(10)).toString();
			}
		return this.cardId;
	}
	public String generateAccountNumber() {
		 
		Random random=new Random(); 
		int length =10;
		
		
		  accountNo	="";
			for (int i = 0; i <length; i++) {
				accountNo+=((Integer)random.nextInt(10)).toString();

			}
   return this.accountNo; 
		
		}
	public String generatePin() {
		pin="";
		for(int i=0;i<=3;i++) {
			   this.pin+=((Integer)ran.nextInt(10)).toString();
			}
		return this.pin;
	}

	public String getCardId() {
		return cardId;
	}

	public String getAccountNumber() {
		return accountNo;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public void setAccountNumber(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	

	@Override
	public String toString() {
		return "SignIn [cardId=" + cardId + ", firstName=" + firstName + ", secondName=" + secondName + ", surname="
				+ surname + ", gender=" + gender + ", address=" + address + ", age=" + age + ", phoneNo=" + phoneNo
				+ ", pin=" + pin + ", balance=" + balance + "]";
	}

	public void numberofaccounts() {
		// TODO Auto-generated method stub
		
	}

//	public  void addTransaction(String cardId2) {
//		
//		this.transactions.add(cardId2);
//		
//	}
	
	
	
}
