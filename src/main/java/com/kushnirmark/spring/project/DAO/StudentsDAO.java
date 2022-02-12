package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Student;

import java.util.List;

public interface StudentsDAO {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);

    List<Discipline> getDisciplinesStudent(int id);

    List<Discipline> getDisciplinesStudentSemester(int idStud,int idSem);
}
