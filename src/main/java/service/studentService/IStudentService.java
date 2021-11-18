package service.studentService;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> seeAllStudent();
    void addNewStudent(Student student);
    boolean updateStudent(Student student);
    void deleteStudent(int id);
   public Student getStudentByID(int id);
   List<Student> selectListStudentByGradeId(int id);
}
