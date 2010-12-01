package supermarket;

import junit.framework.Assert;

import org.junit.Test;


public class CassierTest {
	
	private ArticleFactory articleFactory = new ArticleFactory();
	private Article article0 = articleFactory.article(1.0);
	private Article article1 = articleFactory.article(1.5);
	private ItemBuilder itemBuilder = new ItemBuilder();

	@Test
	public void testNoItems() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		double total = cassier.total(cart);
		
		Assert.assertEquals(0.0, total, 0.001);
	}

	@Test
	public void testOneItem() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		double total = cassier.total(cart);
		
		Assert.assertEquals(1.0, total, 0.001);
	}

	@Test
	public void testItems() {
		Cassier cassier = new Cassier();
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(2).item());
		double total = cassier.total(cart);
		
		Assert.assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3For2() {
		Cassier cassier = new Cassier();
		cassier.addDiscount(new XForYDiscount(article1, 3, 2));
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(3).item());
		double total = cassier.total(cart);
		
		Assert.assertEquals(4.0, total, 0.001);
	}

	@Test
	public void test3ForPrice() {
		Cassier cassier = new Cassier();
		cassier.addDiscount(new AmountForPriceDiscount(article1, 3, new Price(2.5)));
		Cart cart = new Cart();
		cart.add(itemBuilder.create(article0).amount(1).item());
		cart.add(itemBuilder.create(article1).amount(3).item());
		double total = cassier.total(cart);
		
		Assert.assertEquals(3.5, total, 0.001);
	}
}
