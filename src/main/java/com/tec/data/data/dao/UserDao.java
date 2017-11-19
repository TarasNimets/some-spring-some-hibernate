package com.tec.data.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tec.data.data.model.User;

public class UserDao {

    private DataSource dataSource;

    public List<User> selectAllUser() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "SELECT * FROM users";
        return template.query(query, UserMapper.instance);
    }

    private static class UserMapper implements RowMapper<User> {

        public static final UserMapper instance = new UserMapper();

        @Override
        public User mapRow(ResultSet result, int arg1) throws SQLException {
            User user = new User(result.getInt("id"), result.getString("login"), result.getString("password"));
            return user;
        }

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
