package patterns.observable;

public interface StockListener {
	
	public void stockPriceChanged(Stock stock, double newPrice);
		
	
}
