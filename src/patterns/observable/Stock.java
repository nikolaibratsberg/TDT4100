package patterns.observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	private final String ticker;
	private double price;
	private Map<StockListener, ArrayList<Double>> listeners;
	
	public Stock(String ticker, double price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Stock price must be larger than zero");
		}
		this.ticker = ticker;
		this.price = price;
		listeners = new HashMap<StockListener,ArrayList<Double>>();
	}

	// Endringsmetoden kaller alle lytternes lyttermetode
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
		if (listeners.containsKey(listener)) {
			throw new IllegalArgumentException("Object is already an observer");
		}
		listeners.put(listener,null);
	}
	
	public void addStockListener(StockListener listener, double min, double max) {
		if (min >= max) {
			throw new IllegalArgumentException("Illegal interval range");
		}
		
		ArrayList<Double> interval = new ArrayList<Double>();
		interval.add(min); interval.add(max);
		listeners.put(listener, interval);

		
	}
	
	public void removeStockListener(StockListener listener) {
		if (!listeners.containsKey(listener)) {
			throw new IllegalArgumentException("Object is not an observer");
		}
		listeners.remove(listener);
	}
	
	//Hjelpemetode for aa oppdatere lyttere
	private void firePriceChanged(double newPrice) {
		for (StockListener listener : listeners.keySet()) { 
			if (listeners.get(listener) == null) {
				listener.stockPriceChanged(this, this.price, newPrice);
			}
			else if (newPrice < listeners.get(listener).get(0) || newPrice > listeners.get(listener).get(1)) {
				listener.stockPriceChanged(this, this.price, newPrice);
			}
		}
	}
	
}
