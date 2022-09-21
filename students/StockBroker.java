package unisa.dse.a2.students;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StockBroker {

	/**
	 * List of pending trades to be completed. Must store a generic type.
	 */
	private Queue<Trade> pendingTrades = new LinkedList<Trade>();

	
	/**
	 * List of stocks this stock broker is "watching"
	 */
	private DSEListGeneric<String> watchList = new DSEListGeneric<String>();

	/**
	 * returns a DEEP copy of the watchlist. Changes to the list returned from here
	 * should NOT change the list stored by this broker
	 * @return
	 */
	public DSEListGeneric<String> getWatchlist() {
		return new DSEListGeneric<String>(watchList);
	}
	
	/**
	 * Adds the company code to the watchlist if it's not null and not already in there
	 * @param companyCode
	 * @return true if added
	 */
	public boolean addWatchlist(String companyCode){
		
			if(watchList.contains(companyCode) || watchList == null) {
				return false;
			}
			
			else {
				
				watchList.add(companyCode);
			
			}
	
		return true;
	
	}
	
	private String name;

	/**
	 * Name of the stock brokerage firm
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Should store the broker's name and ensure the broker is setup ready to use
	 * @param name
	 */
	public StockBroker(String name){
	
		this.name = name;
		this.pendingTrades = new LinkedList<Trade>();
		this.watchList = new DSEListGeneric<String>();
	
	}
	
	/**
	 * Adds the Trade to the pendingTrades list if it's not null and not already in there
	 * @param companyCode
	 * @return true if added
	 */
	public boolean placeOrder(Trade order){
	
		if(this.pendingTrades.contains(order) || order == null) {
			return false;
		}
		
		else {
			
			this.pendingTrades.add(order);
		
		}

	return true;
	
	}
	
	/**
	 * Gets, removes, and returns the next trade to process
	 * @return Trade to process
	 */
	public Trade getNextTrade(){
		
		Trade t = this.pendingTrades.poll();
		return t;
		
	}
	
	/**
	 * @return Number of pending trades
	 */
	public int getPendingTradeCount(){
		
		int pendingCount = this.pendingTrades.size();
		return pendingCount;
	
	}

	/**
	 * Do not modify this equals, it is used for testing purposes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockBroker other = (StockBroker) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
