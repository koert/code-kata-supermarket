package supermarket;


public class ThreeForTwoDiscount implements Discount {

	private final Article article;

	public ThreeForTwoDiscount(Article article) {
		this.article = article;
	}

	@Override
	public double discount(Cart cart) {
		int amount = 0;
		for (Item item : cart.getItemsByArticle(article)) {
			amount += item.getAmount();
		}
		double discount = (amount / 3) * article.total(1);
		return discount;
	}

}
