package supermarket;

import java.util.List;

public class AmountForPriceDiscount implements Discount {

	private final Article article;
	private final int amount;
	private final Price price;

	public AmountForPriceDiscount(Article article, int amount, Price price) {
		this.article = article;
		this.amount = amount;
		this.price = price;
	}

	@Override
	public double discount(Cart cart) {
		int numberOfItems = 0;
		List<Item> allItems = cart.getItemsByArticle(article);
		for (Item item : allItems) {
			numberOfItems += item.getAmount();
		}
		double discount = article.total(numberOfItems) - price.total(numberOfItems / amount);
		return discount;
	}

}
