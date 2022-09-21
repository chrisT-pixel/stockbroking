package unisa.dse.a2.marking;
import unisa.dse.a2.students.UntradedCompanyException;

import static org.junit.Assert.assertEquals;

import unisa.dse.a2.students.ListedCompany;
import unisa.dse.a2.students.SecuritiesExchange;
import unisa.dse.a2.students.StockBroker;
import unisa.dse.a2.students.Trade;
import unisa.dse.a2.students.UntradedCompanyException;

public class Driver {

	SecuritiesExchange exchange;

	public static void main(String[] args) throws UntradedCompanyException {

		Driver d = new Driver();

	}

	public Driver() throws UntradedCompanyException {
		
		/*SecuritiesExchange asx = new SecuritiesExchange("ASX");
		ListedCompany pear = new ListedCompany("PEAR", "Pear Computer Limited", 50);
		ListedCompany orange = new ListedCompany("ORNG", "Orange Computer Limited", 100);
		asx.addCompany(pear);
		asx.addCompany(orange);
		StockBroker alex = new StockBroker("Alex Aces");
		StockBroker dave = new StockBroker("Dodge Daves");
		asx.addBroker(alex);
		asx.addBroker(dave);
		
		Trade alexT1 = new Trade(alex, "PEAR", 100);
		alex.placeOrder(alexT1);
		Trade alexT2 = new Trade(alex, "ORNG", -600);
		alex.placeOrder(alexT2);
		Trade alexT3 = new Trade(alex, "ORNG", 200);
		alex.placeOrder(alexT3);
		
		System.out.print("alex pending trade count " + alex.getPendingTradeCount());

		Trade daveT1 = new Trade(dave, "ORNG", 300);
		dave.placeOrder(daveT1);
		Trade daveT2 = new Trade(dave, "PEAR", -100);
		dave.placeOrder(daveT2);
		
		System.out.print("dave pending trade count " + dave.getPendingTradeCount());
		
		System.out.print(asx.companies);
		
		System.out.print(asx.processTradeRound());
		
		System.out.print(pear.getCurrentPrice());
		
		//Trade daveT3 = new Trade(dave, "TSLA", 800);
		//dave.placeOrder(daveT3);
		
		Trade daveT6 = new Trade(dave, "PEAR", -100);
		dave.placeOrder(daveT6);
		Trade daveT7 = new Trade(dave, "ORNG", 900);
		dave.placeOrder(daveT7);
		
		System.out.print("dave pending trade count " + dave.getPendingTradeCount());
		
		System.out.print(asx.companies);
		
		System.out.print(asx.processTradeRound());
		
		System.out.print(pear.getCurrentPrice());
		
		asx.processTradeRound();
		
		System.out.print(orange.getCurrentPrice());*/
		
		//StockBroker dodgeBroker = new StockBroker("Test Broker");
		//dodgeBroker.addWatchlist("DALL");
		
		//StockBroker dodgeBroker = new StockBroker("Test Broker");
		//dodgeBroker.addWatchlist("DALL");
		
		/*Trade t1 = new Trade(dodgeBroker, "DALL", 1000);
		Trade t2 = new Trade(dodgeBroker, "TSLA", 1000);
		Trade t3 = new Trade(dodgeBroker, "MSFT", 1000);
		
		System.out.print("\n" + t1.compareTo(t2) + "\n");
		
		System.out.print("\n" + t2.compareTo(t1) + "\n");
		
		System.out.print("\n" + t1.compareTo(t1) + "\n");*/
		
		
		exchange = new SecuritiesExchange("ASX");
		
		StockBroker harry = new StockBroker("Honest Harry Broking");
		exchange.addBroker(harry);
		
		StockBroker dave = new StockBroker("Dodge Dave Broking");
		exchange.addBroker(dave);
		
		ListedCompany dall = new ListedCompany("DALL", "Dall Computers Limited", 1000);
		ListedCompany gs = new ListedCompany("GME", "GameStonk", 100);
		ListedCompany tisla = new ListedCompany("TSLA", "Tisla Intergalactic", 9000);
		ListedCompany wiki = new ListedCompany("WIKI", "Wikipedia", 0);
		
		exchange.addCompany(dall);
		exchange.addCompany(gs);
		exchange.addCompany(tisla);
		
		harry.placeOrder(new Trade(harry, "DALL", 100));
		dave.placeOrder(new Trade(dave, "TSLA", 100));
		
		try
		{
			exchange.processTradeRound();
			
			for (int i = 0; i < exchange.announcements.size(); i++)
			{
				System.out.println(exchange.announcements.get(i));
			}
		} 
		catch (UntradedCompanyException x)
		{
			System.out.println(x.getMessage());
		}
		
		
		
	}

}
