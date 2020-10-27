package com.springdemovideo.springdemovideo.dao;

import com.springdemovideo.springdemovideo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres-person")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{id, person.getName()});
        return  1;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name, favoritefood FROM person";
        List<Person> people = jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");

            Person person = new Person(id,name);

            if(resultSet.getString("favoritefood") != null){
                person.addFavoriteFood(UUID.fromString(resultSet.getString("favoritefood")));
            }
            return person;
        });
        return people;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {

        final String sql = "SELECT id, name, favoritefood FROM person WHERE id = ? ";

        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) ->{
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");

                    Person temp = new Person(personId,name);

                    if(resultSet.getString("favoritefood") != null){
                        temp.addFavoriteFood(UUID.fromString(resultSet.getString("favoritefood")));
                    }
                    return temp;
                });

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {

        final String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
        return  1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{person.getName(), id});
        return  1;
    }

    @Override
    public int addFavoriteFood(UUID id, UUID foodID) {
        final String sql = "UPDATE person SET favoritefood = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{foodID, id});
        return  1;
    }
}
