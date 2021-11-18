package service.teacherservice;

import model.Course;
import model.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> selectAllTeacher();
    Teacher selectTecherById(int id);
    void addTeacher(Teacher teacher, int [] courseids);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById(int id);
}
