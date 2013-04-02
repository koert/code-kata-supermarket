package supermarket;


public class XForYDiscount implements Discount {

	private final Article article;
	private final double itemAmount;
	private final double forAmount;

	public XForYDiscount(Article article, double xAmount, double yAmount) {
		this.article = article;
		this.itemAmount = xAmount;
		this.forAmount = yAmount;
	}

	@Override
	public double discount(Cart cart) {
		int amount = 0;
		for (Item item : cart.getItemsByArticle(article)) {
			amount += item.getAmount();
		}
		double discount = (amount / itemAmount) * article.total(itemAmount - forAmount);
		return discount;
	}

}
