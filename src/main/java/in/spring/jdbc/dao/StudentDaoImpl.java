package in.spring.jdbc.dao;

import in.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl  implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String q = "insert into student (id , name , city) values (?,?,?)";
        int r = this.jdbcTemplate.update(q, student.getId(),student.getName(),student.getCity());
        return r ;
    }

    @Override
    public int update(Student student) {
        String q = "update student set name = ? , city = ? where id = ?";
        int r = this.jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(Student student) {
        String q  = "delete from student where id=?";
        int r = this.jdbcTemplate.update(q,student.getId());
        return r;
    }

    @Override
    public Student getStudent(int id) {
        String q= "select * from Student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(q,rowMapper,id);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String q = "select * from Student";
        List<Student > students = this.jdbcTemplate.query(q, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
