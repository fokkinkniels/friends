package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("MySql-User")
public class UserDataAccessService implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate; }

    @Override
    public int insertUser(int id, User user) {
        final String sql = "INSERT INTO user (id, username) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{id, user.getUsername()});
        return  1;
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT id, username FROM user";
        List<User> users = jdbcTemplate.query(sql, (resultSet, i) ->{
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("username");

            return new User(id,name);
        });
        return users;
    }

    @Override
    public Optional<User> selectUserById(int id) {

        final String sql = "SELECT id, username FROM user WHERE id = ? ";

        User user = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) ->{
                    int userId = Integer.parseInt(resultSet.getString("id"));
                    String userName = resultSet.getString("username");

                    return new User(userId, userName);
                });

        return Optional.ofNullable(user);
    }

    @Override
    public int deleteUserById(int id) {

        final String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
        return  1;
    }

    @Override
    public int updateUserById(int id, User user) {

        final String sql = "UPDATE user SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{user.getUsername(), id});
        return  1;
    }
}
