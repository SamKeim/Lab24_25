package co.grandcircus.Lab24_25.entities;

public class Product {

	private Long id;
	private String category;
	private String name;
	private String description;
	private Long quantity;
	private Double price;
	
	public Product() {
		
	}
	
	public Product(Long id, String category, String name, String description, Long quantity, Double price) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


}
