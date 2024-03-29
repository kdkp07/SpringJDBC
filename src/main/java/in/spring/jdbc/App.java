package in.spring.jdbc;

import in.spring.jdbc.dao.StudentDao;
import in.spring.jdbc.dao.StudentDaoImpl;

import java.util.Arrays;
import java.util.List;
import in.spring.jdbc.entities.Student;
import in.spring.jdbc.resources.springConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("====================The program is starting===================");
        System.out.println("+                                                      +");
        System.out.println("+                                                      +");
        System.out.println("+                                                      +");
        System.out.println("+                                                      +");
        System.out.println("+                                                      +");
        String config_file_loc = "src/applicationContext.xml";
//        File f = new File(config_file_loc);
//        System.out.println("Exist test: " + f.exists());
//        ApplicationContext context = new ClassPathXmlApplicationContext(config_file_loc);
        /*
        Naive approach
        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        // insert query
        String q = "insert into Student (id,name,city) values (?,?,?)";
        // shoot the query
        int result = template.update(q,208,"Anshu Suman" , "Nalanda");
        System.out.println("# of record(s) inserted = "+result);
        */
        // Design based approach
        ApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);

//        Student student = new Student();
//        student.setId(157);
//        student.setName("Sanket");
//        student.setCity("Kalaburgi");

        StudentDao studentDao = context.getBean("stdDao",StudentDao.class);

        // insert student
//        int result = studentDao.insert(student);
//        System.out.println("# of record inserted = " + result);

        // update student
//        int res = studentDao.update(student);
//        System.out.println("# of record updated = " + res);

        // delete student
//        int deleted = studentDao.delete(student);
//        System.out.println("# of record deleted = " + deleted );

        // select student
//        Student student = studentDao.getStudent(159);
//        System.out.println(student);

        // selecting multiple students or rows from the database;
        List<Student> students  = studentDao.getAllStudent();
        for(Student it  : students){
            System.out.println(it);
        }

    }
}
