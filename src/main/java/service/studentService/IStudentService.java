package service.studentService;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> studentList();
    void addNewStudent(Student student);
    boolean updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentByID(int id);
}
