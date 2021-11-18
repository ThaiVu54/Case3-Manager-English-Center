package service.teacherconnectsourse;

import model.Course;
import model.Teacher;
import model.TeacherConnectCourse;

import java.util.List;

public interface ITeacherConnectSourceService {
    List<TeacherConnectCourse> selectAllTeacherConnectSource();
    List<Teacher> selectAllTeacherByCourseId(int id);
    List<Course> selectAllCourseByTeacherId(int id);
}
