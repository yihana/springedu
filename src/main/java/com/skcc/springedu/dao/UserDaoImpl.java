package com.skcc.springedu.dao;

import com.skcc.springedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HyunSub Shim
 * @since 1.0
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static final String SELECT_ALL = "select * from users";
    private static final String SELECT_USER_ID = "select * from users where id = ?";
    private static final String INSERT_USER = "insert into users values(?, ?, ?)";
    private static final String DELETE_USER = "delete from users where id = ?";
    private static final String UPDATE_USER = "update users set name = ?, age = ? where id = ?";

    private static final RowMapper<User> USER_ROW_MAPPER = (resultSet, i) -> {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        return user;
    };

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, USER_ROW_MAPPER);
    }

    @Override
    public User selectUser(int id) {
        return jdbcTemplate.queryForObject(SELECT_USER_ID, new Object[]{id}, USER_ROW_MAPPER);
    }

    @Override
    public int insertUser(User user) {
        return jdbcTemplate.update(INSERT_USER, user.getId(), user.getName(), user.getAge());
    }

    @Override
    public int deleteUser(int id) {
        return jdbcTemplate.update(DELETE_USER, id);
    }

    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update(UPDATE_USER, user.getName(), user.getAge(), user.getId());
    }
}
