package service.gradeservice;

import model.Grade;

import java.util.List;

public interface IGradeService {
    List<Grade> selectAllGrade();
    Grade selectGradebyId(int id);
    void addGrade(Grade grade);
    void updateGrade(Grade grade);
    void deleteGrade(Grade grade);
}
