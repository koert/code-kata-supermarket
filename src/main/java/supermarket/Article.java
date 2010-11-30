package supermarket;

public class Article {

	private final Price price;

	public Article(Price price) {
		this.price = price;
	}

	public double total(int amount) {
		return price.total(amount);
	}

}
