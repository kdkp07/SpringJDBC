package in.spring.jdbc.dao;

import in.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCity(rs.getString(3));
        return student;
    }
}
