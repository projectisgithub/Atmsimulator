package simulator.atm;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class LogIn {
	static double balance;
	static String name;
	public LogIn() {
		TransacTion transaction=new TransacTion ();
	transaction.LogIn1();
		// TODO Auto-generated constructor stub
	}
	

	
	static private String cardId;
	private String pin;
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public SignIn getStud() {
		return stud;
	}
	public void setStud(SignIn stud) {
		this.stud = stud;
	}
	public void setbalance(double balance) {
		this.balance = balance;
	}
	
	
	
	public LogIn(String cardId, String pin) {
		
		this.cardId = cardId;
		this.pin = pin;
		
		
	}
public LogIn(String id) {
		
		this.cardId = id;
		
}
	


	public LogIn(double d) {
	// TODO Auto-generated constructor stub
}

	public static void chechPin(String pin) {
		Scanner sc=new Scanner(System.in);
		String npin;
		
		if (stud.getPin().equals(pin)) {
			
			do {System.out.println("Enter new pin (4 digit numerical key): ");
			npin=sc.next();
				if (npin.length() < 5 && npin.length() > 3) {
					Configuration cfg = new Configuration().configure("atm.cfg.xml");
					SessionFactory sf = cfg.buildSessionFactory();
					Session session = sf.openSession();
					Transaction tx = session.beginTransaction();
					stud = (SignIn) session.get(SignIn.class, cardId);

					Query query = session.createQuery("update SignIn stud set pin=:npin where cardId=:cardId");
					query.setParameter("npin", npin);
					query.setParameter("cardId", cardId);
					query.executeUpdate();
					tx.commit();
					System.out.println("New pin set.");
				} else {
					System.out.println("Please try again later.");
					System.exit(0);
				}
			} while (npin.length() < 5 && npin.length() > 3);
				
			}
		}
	

	Scanner sc = new Scanner(System.in);
	static SignIn stud;
	SignIn fullobj;
	public SignIn verify(String cardId) {
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		stud = (SignIn)session.get(SignIn.class, cardId);
		//System.out.println(stud);
		//System.out.println(stud.getBalance());
		name=stud.getFirstName();
		if(stud==null) {
			System.out.println("Invalid card id or pin");
			LogIn lo=new LogIn();
		}
		if (!this.pin.equals(stud.getPin())){
			System.out.println("Invalid card id or pin");
			LogIn lo=new LogIn();
		}
		//System.out.println(stud.getBalance());
		System.out.println("Hello "+stud.getFirstName()+" "+stud.getSurname());
		balance=stud.getBalance();
		//stud.setBalance=(LogIn.getbalance()-1000);
		return stud;
	}
	
	
	
	public void setFirstname(String name) {
		this.name=name;
	}
	
	public void withBal(double amount) {
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		stud = (SignIn)session.get(SignIn.class, cardId);
		if(stud.getBalance()<amount) {
			System.out.println("Not enough balance in your account.");
			System.out.println("Please try again later");
			System.exit(0);
		}
		else if(amount>20000) {
			System.out.println("Maximum limit for withdrawl is Rs 20000.");
			System.out.println("Please try again later");
			System.exit(0);
		}
			Double upBalance = stud.getBalance() - amount;
			//		stud.setBalance(upBalance);
			//System.out.println(upBalance);
			Query query = session.createQuery("update SignIn stud set balance=:upBalance where cardId=:cardId");
			query.setParameter("upBalance", upBalance);
			query.setParameter("cardId", cardId);
			query.executeUpdate();
			tx.commit();
			//System.out.println("Current Balance is "+stud.getBalance());
			System.out.println("Please collect cash.");
			System.out.println("Current balance = "+ (stud.getBalance()-amount));
			
		
	}
	public void depBal(double amount) {
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		stud = (SignIn)session.get(SignIn.class, cardId);
	    if(amount>20000) {
		System.out.println("Maximum limit for deposit is Rs 20000.");
		System.out.println("Please try again later");
		System.exit(0);
		
	    }
			Double upBalance = stud.getBalance() + amount;
			//		stud.setBalance(upBalance);
			//System.out.println(upBalance);
			Query query = session.createQuery("update SignIn stud set balance=:upBalance where cardId=:cardId");
			query.setParameter("upBalance", upBalance);
			query.setParameter("cardId", cardId);
			query.executeUpdate();
			tx.commit();
			System.out.println("Amount deposited succesfully");
			System.out.println("Current balance = "+(stud.getBalance()+amount));
			
			
	}
	
	public void transferBal(double amount,String accountNo) {
		SignIn beneficiary ;
		//System.out.println("Plese enter ");
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		stud = (SignIn)session.get(SignIn.class, cardId);
			Double upBalance = stud.getBalance() - amount;
			stud.setBalance(upBalance);
			Query query = session.createQuery("update SignIn stud set balance=:upBalance where cardId=:cardId");
			query.setParameter("upBalance", upBalance);
			query.setParameter("cardId", cardId);
			query.executeUpdate();
			System.out.println("Rs "+amount+" transferred successfully.");
			
			
			//Query query1 = session.createQuery("from SignIn ")
			Query<SignIn> query2 = session.createQuery("from SignIn SignIn_info where SignIn_info.accountNo='"+accountNo+"'");
			SignIn list=query2.list().get(0);
			String ci=list.getCardId();
			double nb=(list.getBalance()+amount);
			Query query3 = session.createQuery("update SignIn stud set balance=:nb where cardId=:cardId");
			query3.setParameter("nb", nb);
			query3.setParameter("cardId", ci);
			query3.executeUpdate();
			
//			double upBalance2 = beneficiary.getBalance()+amount;
//			query.setParameter("upBalance2", upBalance2);
//			query.setParameter("accountNo", accountNo);
//			query2.executeUpdate();
			tx.commit();
//			System.out.println("Current balance is "+stud.getBalance());
//			
//		
	}
	public void pin(String pin) {
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		stud = (SignIn)session.get(SignIn.class, cardId);
	   	Query query = session.createQuery("update SignIn stud set pin=:pin where cardId=:cardId");
			query.setParameter("pin", pin);
			query.setParameter("cardId", cardId);
			query.executeUpdate();
			tx.commit();
			System.out.println("New pin set: "+pin);
			
			
	}
	public void trans() {
		Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query<Trans> query=session.createQuery("From Trans");
		List<Trans> list=query.list();
		list.stream().filter(p->p.getCardid().equals(cardId)).forEach(System.out::println);
//		for(Trans u:list) {
//			System.out.println(u);}
		session.close();
	}
	public static String getFirstname() {
		return name;
	}
	public static double getbalance() {
		return balance;
	}

}