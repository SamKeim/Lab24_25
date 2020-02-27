package co.grandcircus.Lab24_25.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.Lab24_25.pojos.Product;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbc;

	public void addProduct(Product product) {
		String sql = "INSERT INTO products (name, category, description, price) VALUES (?, ?, ?, ?);";
		jdbc.update(sql, product.getName(), product.getCategory(), product.getDescription(),
				product.getPrice());
	}

	public List<Product> findAll() {
		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}

	public void update(Product product) {
		String sql = "UPDATE products SET category=?, name=?, description=?, price=? WHERE id=?";
		jdbc.update(sql, product.getCategory(), product.getName(), product.getDescription(),
				product.getPrice(), product.getId());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM products WHERE id = ?";
		jdbc.update(sql, id);
	}

	public Product findById(Long id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
	}
	
	public Long findByName(String name) {
		String sql = "SELECT id FROM products WHERE name = ?";
		return jdbc.queryForObject(sql, Long.class, name);
	}
	
	public List<String> findCategories() {
		String sql = "SELECT DISTINCT category FROM products";
		return jdbc.queryForList(sql, String.class);
	}
	
	public List<String> findNames() {
		String sql = "SELECT DISTINCT name FROM products";
		return jdbc.queryForList(sql, String.class);
	}
}
