package simulator.atm;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Trans {
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	@Transient
	private ArrayList<Trans> transactions;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int count;
	private String cardid;
	private String name;
	private Date date;
	private double amt;
	private String transactType;
	
	
public Trans(String cardid,String name,Date date,double amt,String transactType) { 

 this.transactions=new ArrayList<Trans>();
 this.cardid=cardid;
 this.date=date;
 this.name=name;
this.amt=amt;
this.transactType=transactType;
		
}
 public void addTransactions(String cardid,String name,Date date,double ammount,String transType) {
	Trans trans=new Trans(cardid,name,date,ammount,transactType);
	//this.transactions.add(trans);
	Configuration cfg = new Configuration().configure("atm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(trans);
		tx.commit();
		session.close();
		sf.close();
	 
 }
@Override
public String toString() {
	return "Transaction [Card Id=" + cardid + ", Name=" + name + ", Date=" + date + ", Amount="
			+ amt + ", Transaction Type=" + transactType + "]";
}
public Trans() {
	super();
	// TODO Auto-generated constructor stub
}
public ArrayList<Trans> getTransactions() {
	return transactions;
}
public void setTransactions(ArrayList<Trans> transactions) {
	this.transactions = transactions;
}
public void setamt(double amt) {
	this.amt=amt;
}
public double getamt() {
	return amt;
}
public void ShowTransactionHistory(String cardId) {
	for (int i = 0; i < transactions.size(); i++) {
		System.out.println(transactions.get(i).cheeckAccount(cardId));
    
	}
	
}
private String cheeckAccount(String cardId) {
	return cardId;
	
	
}
private void getSummary() {
	
}



}