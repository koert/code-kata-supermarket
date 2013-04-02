package supermarket;

public class ItemBuilder {

	public ItemSpecifier create(Article article) {
		return new ItemSpecifier(article);
	}

	public static class ItemSpecifier {
		private Article article;
		private double amount;
		
		public ItemSpecifier(Article article) {
			this.article = article;
		}

		public ItemSpecifier amount(int amount) {
			this.amount = amount;
			return this;
		}

		public Item item() {
			return new Item(article, amount);
		}
		
	}
}
