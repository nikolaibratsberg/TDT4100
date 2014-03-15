package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private final String ticker;
	private double price;
	private List<StockListener> listeners;
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.price = price;
		listeners = new ArrayList<StockListener>();
	}

	// Endringsmetoden kaller alle lytternes lyttermetoder
	public void setPrice(double newPrice) {
		firePriceChanged(newPrice);
		this.price = newPrice;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getTicker() {
		return this.ticker;
	}

	
	public void addStockListener(StockListener listener) {
		listeners.add(listener);
	}
	
	public void removeStockListener(StockListener listener) {
		listeners.remove(listener);
	}
	
	public void firePriceChanged(double newPrice) {
		for (StockListener listener : listeners) { 
			listener.stockPriceChanged(this, newPrice);
		}
	}
	
}
