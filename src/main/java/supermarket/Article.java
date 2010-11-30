package supermarket;

public class Article {

	private final Price price;
	private final int id;

	public Article(int id, Price price) {
		this.id = id;
		this.price = price;
	}

	public double total(int amount) {
		return price.total(amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
