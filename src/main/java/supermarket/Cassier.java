package supermarket;

import java.util.ArrayList;
import java.util.List;

public class Cassier {

	private List<Discount> discounts = new ArrayList<Discount>();
	
	public double total(Cart cart) {
		double total = cart.total();
		for (Discount discount : discounts) {
			total -= discount.discount(cart);
		}
		return total;
	}

	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}

}
