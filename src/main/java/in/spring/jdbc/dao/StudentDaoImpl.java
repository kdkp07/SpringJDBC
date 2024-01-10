package in.spring.jdbc.dao;

import in.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setCity(rs.getString(3));
                return student;
            }
        };
        Student student = this.jdbcTemplate.queryForObject(q,rowMapper,id);
        return student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
