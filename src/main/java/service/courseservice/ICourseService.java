package service.courseservice;

import model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> selectAllCourse();
    Course selectCourseById(int id);
    void addCourse(Course course, int[] teacherid);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
