package patterns.observable;



public class StockIndex implements StockListener{
	
	private String name;
	private double index; 
	

	public StockIndex(String name, Stock... stocks) {
		this.name = name;

		for (Stock s : stocks) {
			s.addStockListener(this);
			this.index += s.getPrice();
		
		}	
	}
	
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		this.index += newPrice - oldPrice;
	}
	
	
	public void addStock(Stock stock) {
		stock.addStockListener(this);
		this.index += stock.getPrice();
	}
	
	public void removeStock(Stock stock) {
		stock.removeStockListener(this);
		this.index -= stock.getPrice();
		
	}
	
	public double getIndex() {
		return this.index;
	}
	
	public String toString() {
		return "The stock index " + name + " is " + index;
	}
	
	
}
