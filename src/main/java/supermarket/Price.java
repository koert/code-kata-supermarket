package supermarket;

public class Price {

	private final double price;

	public Price(double price) {
		this.price = price;
	}

	public double total(int amount) {
		return price * amount;
	}

}
