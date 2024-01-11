package in.spring.jdbc.dao;

import in.spring.jdbc.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int update(Student student);
    public int delete(Student student);
    public Student getStudent(int id);
    public List<Student> getAllStudent();
}


