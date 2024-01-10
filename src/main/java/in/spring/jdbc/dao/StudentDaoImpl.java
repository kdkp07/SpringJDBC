package in.spring.jdbc.dao;

import in.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
