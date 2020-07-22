package com.boushib.recruitment.dao;

import com.boushib.recruitment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresDao implements UserDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PostgresDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int signup(User user) {
    String sqlQuery = "INSERT INTO users (id, name, email, password, gender) VALUES(?, ?, ?, ?, ?);";
    jdbcTemplate.update(sqlQuery, UUID.randomUUID(), user.getName(), user.getEmail(), user.getPassword(), user.getGender());
    return 1;
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    String sqlQuery = "SELECT * FROM users WHERE id = ?;";
    User user = jdbcTemplate.queryForObject(sqlQuery, new Object[]{id},((resultSet, i) -> {
      UUID user_id = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String password = resultSet.getString("password");
      String gender = resultSet.getString("gender");
      String account_type = resultSet.getString("account_type");
      Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
      Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));

      return new User(user_id, name, email, password, gender, account_type, created_at, updated_at);
    }));
    return Optional.ofNullable(user);
  }

  @Override
  public int updateUser(UUID id, User user) {
    return 0;
  }

  @Override
  public int deleteUser(UUID id) {
    return 0;
  }

  @Override
  public List<User> getUsers() {
    String sqlQuery = "SELECT * FROM users;";
    return jdbcTemplate.query(sqlQuery, ((resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String password = resultSet.getString("password");
      String gender = resultSet.getString("gender");
      String account_type = resultSet.getString("account_type");
      Timestamp created_at = Timestamp.valueOf(resultSet.getString("created_at"));
      Timestamp updated_at = Timestamp.valueOf(resultSet.getString("updated_at"));

      return new User(id, name, email, password, gender, account_type, created_at, updated_at);
    }));
  }
}
