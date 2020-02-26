package co.grandcircus.Lab24_25.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.Lab24_25.entities.User;

@Repository
public class UserDao {

		@Autowired
		private JdbcTemplate jdbc;
		

		public void addUser(User user) {
			String sql = "INSERT INTO users (first_name, last_name, email, phone_number, password) VALUES (?, ?, ?, ?, ?);";
			jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getPassword());
			
		}
		
		public User findById(Long id) {
			String sql = "SELECT * FROM users WHERE id = ?;";
			return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
		}
		public User findByEmail(String email) {
			String sql = "SELECT * FROM users WHERE email = ?;";
			return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), email);
		}
		
		

}
