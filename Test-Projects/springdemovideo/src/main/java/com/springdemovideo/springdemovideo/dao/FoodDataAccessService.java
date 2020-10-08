package com.springdemovideo.springdemovideo.dao;

import com.springdemovideo.springdemovideo.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres-food")
public class FoodDataAccessService implements FoodDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FoodDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertFood(UUID id, String name, String color) {
        final String sql = "INSERT INTO food (foodid, name, color) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{id, name, color});
        return  1;
    }

    @Override
    public List<Food> selectAllFood() {
        final String sql = "SELECT foodID, name, color FROM food";
        List<Food> food = jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID id = UUID.fromString(resultSet.getString("foodID"));
            String name = resultSet.getString("name");
            String color = resultSet.getString("color");
            return new Food(id,name, color);
        });
        return food;
    }

    @Override
    public Optional<Food> selectFoodById(UUID id) {

        final String sql = "SELECT name, color FROM food WHERE foodID = ? ";

        Food food = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) ->{
                    String name = resultSet.getString("name");
                    String color = resultSet.getString("color");
                    return new Food(id, name, color);
                });

        return Optional.ofNullable(food);
    }

    @Override
    public int deleteFoodById(UUID id) {

        final String sql = "DELETE FROM food WHERE foodID = ?";
        jdbcTemplate.update(sql, new Object[]{id});
        return  1;
    }

    @Override
    public int updateFoodById(UUID id, String name, String color) {
        final String sql = "UPDATE food SET name = ?, color = ? WHERE foodID = ?";
        jdbcTemplate.update(sql, new Object[]{name, color, id});
        return  1;
    }
}
