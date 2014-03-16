package patterns.observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
	
	private final String ticker;
	private double price;
	private List<StockListener> listeners;
	
	public Stock(String ticker, double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Stock price must be larger than zero");
		}
		this.ticker = ticker;
		this.price = price;
		listeners = new ArrayList<StockListener>();
	}

	// Endringsmetoden kaller alle lytternes lyttermetoder
	
	
	public void setPrice(double newPrice) {
		if (newPrice <= 0) {
			throw new IllegalArgumentException("Stock price must be larger than zero");
		}
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
		if (listeners.contains(listener)) {
			throw new IllegalArgumentException("Object is already an observer");
		}
		listeners.add(listener);
	}
	
	public void addStockListener(StockListener listener, double min, double max) {
		listeners.add(listener);

		
	}
	
	public void removeStockListener(StockListener listener) {
		if (!listeners.contains(listener)) {
			throw new IllegalArgumentException("Object is not an observer");
		}
		listeners.remove(listener);
	}
	
	//Hjelpemetode for aa oppdatere lyttere
	private void firePriceChanged(double newPrice) {
		for (StockListener listener : listeners) {  
			listener.stockPriceChanged(this, this.price, newPrice);
		}
	}
	
}
