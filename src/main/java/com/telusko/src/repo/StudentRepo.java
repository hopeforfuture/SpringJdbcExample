package com.telusko.src.repo;

import com.telusko.src.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student s) {

        String sql = "INSERT INTO student(id, name, marks, rollno) VALUES (NULL, ?, ?, ?)";

       int rows = jdbc.update(sql,
           s.getName(),
           s.getMarks(),
           s.getRollno()
        );

        System.out.println(rows + " affected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student ORDER BY id DESC";

        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setRollno(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
    }
}
