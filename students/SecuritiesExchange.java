package unisa.dse.a2.students;

import java.util.HashMap;
import java.util.Scanner;

import unisa.dse.a2.interfaces.ListGeneric;

public class SecuritiesExchange {

	/**
	 * Exchange name
	 */
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * List of brokers on this exchange
	 */
	public DSEListGeneric<StockBroker> brokers;
	
	/**
	 * List of announcements of each trade processed
	 */
	public DSEListGeneric<String> announcements;
	
	/**
	 * HashMap storing the companies, stored based on their company code as the key
	 */
	public HashMap<String, ListedCompany> companies;

	/**
	 * Initialises the exchange ready to handle brokers, announcements, and companies
	 * @param name
	 */
	public SecuritiesExchange(String name){
		this.name = name;
		this.announcements = new DSEListGeneric<String>();
		this.brokers = new DSEListGeneric<StockBroker>();
		this.companies = new HashMap<String, ListedCompany>();
		
	}
	
	/**
	 * Adds the given company to the list of listed companies on the exchange
	 * @param company
	 * @return true if the company was added, false if it was not
	 */
	public boolean addCompany(ListedCompany company){
		
		if(company == null) {
			return false;
		}
		
		String code = company.getCode();
		
		if(companies.containsKey(code)) { // company is already in list
			return false;
		}
		
		else {
		
			companies.put(code, company);
			return true;
			
		}
		
	}

	/**
	 * Adds the given broke to the list of brokers on the exchange
	 * @param company
	 */
	public boolean addBroker(StockBroker broker){
		
		if(brokers.contains(broker)) {
			return false;
		}
		
		else {
		
			boolean added = brokers.add(broker);
			
			if(broker == null) {
				return false;
			}
			
			else if(added) {
				return true;
			}
			
			else {
				return false;
			}
			
		}
		
	}
	
	/**
	 * Process the next trade provided by each broker, processing brokers starting from index 0 through to the end
	 * 
	 * If the exchange has three brokers, each with trades in their queue, then three trades will processed, one from each broker.
	 * 
	 * If a broker has no pending trades, that broker is skipped
	 * 
	 * Each processed trade should also make a formal announcement of the trade to the announcements list in the form a string:
	 * "Trade: QUANTITY COMPANY_CODE @ PRICE_BEFORE_TRADE via BROKERNAME", 
	 * e.g. "Trade: 100 DALL @ 99 via Honest Harry Broking" for a sale of 100 DALL shares if they were valued at $99
	 * Price shown should be the price of the trade BEFORE it's processed. Each trade should add its announcement at 
	 * the end of the announcements list
	 * 
	 * @return The number of successful trades completed across all brokers
	 * @throws UntradedCompanyException when traded company is not listed on this exchange
	 */
	public int processTradeRound() throws UntradedCompanyException{
	
		
		NodeGeneric<StockBroker> currentNode = brokers.head; //start at the head of brokers generic list
		int numProcessed = 0;
	 
	    while (currentNode != null) { 
	      
	    	StockBroker stockBroker = currentNode.get();
	    	int pendingCount = stockBroker.getPendingTradeCount();
	    	
	    	if(pendingCount > 0) { //there are pending trades to process
	    		Trade nextTrade = stockBroker.getNextTrade();
		    	String companyCode = nextTrade.getCompanyCode();
		    	
		    	int qty = nextTrade.getShareQuantity();
		    	ListedCompany company = companies.get(companyCode);
		    	
		    	
		    	if(company == null) { //not a listed company
		    		throw new UntradedCompanyException(companyCode);
		    	}
		    	
		    	else {
		    	
		    		int preTradeVal = company.getCurrentPrice();
		    		company.processTrade(qty); //process trade and modify stock price based on quantity traded
		    		this.announcements.add("Trade: " + qty + " " + companyCode + " @ " + preTradeVal + " via " + stockBroker); //add string to generic announcements list
		    		numProcessed++;
		    	}
	    	}
	      
	    	currentNode = currentNode.next; // go to next node
	    	
	    }
	    
	    return numProcessed;
		
		
		
	}
	
	public int runCommandLineExchange(Scanner sc){
		
		//i'll attempt this once I catch my breath after the semester is over :) 
		return 1;
	
	}
}
