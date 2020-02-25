package co.grandcircus.Lab24_25;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	public void addProduct(Product product) {
		
		String sql = "INSERT INTO products (name, description, price) VALUES (?, ?, ?);";
		jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice());
	}
	
	public List<Product> findAll(){
		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}
	
}
