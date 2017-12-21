package com.example.demo.repo;

import com.example.demo.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class repoImpl extends JdbcDaoSupport implements repoInt {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public user getUserById(String name) {
        String sql = "SELECT * FROM fullName WHERE firstName = ?";
        return (user)getJdbcTemplate().queryForObject(sql, new Object[]{name}, new RowMapper<user>(){
            @Override
            public user mapRow(ResultSet rs, int rwNumber) throws SQLException {
                user newUser = new user();
                newUser.setFirstName(rs.getString("firstName"));
                newUser.setLastName(rs.getString("lastName"));
                return newUser;
            }
        });
    }

    public void addUser(user tempUser) {
        String sql = "INSERT INTO fullName " +
                "(firstName, lastName) VALUES (?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                tempUser.getFirstName(), tempUser.getLastName()
        });
    }
}
