package unisa.dse.a2.students;

public class ListedCompany {

	/**
	 * The full name of the company
	 */
	private String name;
	
	public String getName() {
		return this.name;
	}

	/**
	 * The listing code of the company
	 */
	private String code;
	
	public String getCode() {
		return this.code;
	}

	/**
	 * Current price of the company after last trade
	 */
	private int currentPrice;
	
	public int getCurrentPrice() {
		return this.currentPrice;
	}
	
	public ListedCompany(String code, String name, int currentPrice){
		this.code = code;
		this.name = name;
		this.currentPrice = currentPrice;
	
	}
	
	/**
	 * Processing a trade should increase the current price of the company by 
	 *    quantity / 100
	 * A company's price CANNOT go below 1
	 * 
	 * @param quantity
	 * @return the price after adjustment
	 */
	public int processTrade(int quantity){
		
		int preTradePrice = this.getCurrentPrice();
		int divisor = 100;
		System.out.print("pre trade price for " + this.getName()+ " " + preTradePrice + "\n");
		int priceChange = (quantity / divisor);
		System.out.print("price change " + priceChange + "\n");
		
		int postTradePrice = preTradePrice + priceChange; 
		
		if(postTradePrice < 1) { //stock cannot be valued at less than 1
			this.currentPrice = 1;
			return this.currentPrice;
		}
		
		else {
			this.currentPrice = postTradePrice; //modify price of stock
			System.out.print("post trade price " + postTradePrice + "\n");
		}
		System.out.print("post trade price " + postTradePrice + "\n");
		return postTradePrice;
		
	}
}
