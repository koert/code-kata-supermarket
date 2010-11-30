package supermarket;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> items = new ArrayList<Item>();
	
	public void add(Item item) {
		items.add(item);
	}

	public double total() {
		double total = 0.0;
		for (Item item : items) {
			total += item.total();
		}
		return total;
	}
	
	public List<Item> getItemsByArticle(Article article) {
		List<Item> articleItems = new ArrayList<Item>();
		for (Item item : items) {
			if (item.isArticle(article)) {
				articleItems.add(item);
			}
		}
		return articleItems;
	}

}
