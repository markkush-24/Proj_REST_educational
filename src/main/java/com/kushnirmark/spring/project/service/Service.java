package com.kushnirmark.spring.project.service;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;
import com.kushnirmark.spring.project.entity.Student;

import java.util.List;

public interface Service {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);

    List<Discipline> getDisciplinesStudent(int id);

    List<Discipline> getDisciplinesStudentSemester(int idStud, int idSem);

    //***************************************************************************************************
    List<Discipline> getAllDisciplines();

    void saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

    List<Discipline> getDisciplineList(List<Integer> id);

    //***************************************************************************************************
    List<Semestr> getSemestr();

    List<Discipline> getDisciplineSemestr();

    void saveNewSemester(Semestr semestr);

    List<Discipline> getDisciplineSemestrId(int semId);

    public void deleteSemestr(int id);
}
