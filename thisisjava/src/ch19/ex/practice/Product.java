package ch19.ex.practice;

public class Product {
	private int no;
	private String name;
	private int price;
	private int stock;
	
	public Product() {}
	
	public Product(int no, String name, int price, int stock) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return no == product.no && price == product.price && stock == product.stock && name.equals(product.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Product{" + "no=" + no + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock + '}';
	}
	
}
