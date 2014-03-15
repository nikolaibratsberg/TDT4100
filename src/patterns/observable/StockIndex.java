package patterns.observable;

public class StockIndex implements StockListener{
	
	private String name;
	private double index;

	public StockIndex(String name, Stock s1, Stock s2, Stock s3) {
		this.name = name;
		s1.addStockListener(this); 
		s2.addStockListener(this); 
		s3.addStockListener(this);
		this.index = s1.getPrice() + s2.getPrice() + s3.getPrice();
	}
	
	public void stockPriceChanged(Stock stock, double newPrice) {
		this.index += stock.getPrice() - newPrice;
	}
	
	public double getIndex() {
		return this.index;
	}
	
	
}
