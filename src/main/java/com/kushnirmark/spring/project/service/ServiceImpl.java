package com.kushnirmark.spring.project.service;

import com.kushnirmark.spring.project.DAO.DisciplinesDAO;
import com.kushnirmark.spring.project.DAO.SemestrDAO;
import com.kushnirmark.spring.project.DAO.StudentsDAO;
import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;
import com.kushnirmark.spring.project.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {


    @Autowired
    private StudentsDAO studentsDAO;

    @Autowired
    private DisciplinesDAO disciplinesDAO;

    @Autowired
    private SemestrDAO semestrDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentsDAO.getAllStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentsDAO.saveStudent(student);

    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentsDAO.getStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {

        studentsDAO.deleteStudent(id);
    }

    @Override
    @Transactional
    public List<Discipline> getDisciplinesStudent(int id) {

        return studentsDAO.getDisciplinesStudent(id);
    }

    @Override
    public List<Discipline> getDisciplinesStudentSemester(int idStud, int idSem) {
        return studentsDAO.getDisciplinesStudentSemester(idStud,idSem);
    }
    //**********************************************************************************************************


    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {

        return disciplinesDAO.getAllDisciplines();

    }

    @Override
    @Transactional
    public void saveDiscipline(Discipline discipline) {
        disciplinesDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplinesDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        disciplinesDAO.deleteDiscipline(id);
    }

    @Override
    @Transactional
    public List<Discipline> getDisciplineList(List<Integer> id) {
        return disciplinesDAO.getDisciplineList(id);
    }
//**********************************************************************************************************


    @Override
    @Transactional
    public List<Semestr> getSemestr() {
        return semestrDAO.getSemestr();
    }

    @Override
    @Transactional
    public List<Discipline> getDisciplineSemestr() {
        return semestrDAO.getDisciplineSemestr();
    }

    @Override
    @Transactional
    public void saveNewSemester(Semestr semestr) {
        semestrDAO.saveNewSemester(semestr);
    }


    @Override
    @Transactional
    public List<Discipline> getDisciplineSemestrId(int semId) {
        return semestrDAO.getDisciplineSemestrId(semId);
    }

    @Override
    @Transactional
    public void deleteSemestr(int id) {
        semestrDAO.deleteSemestr(id);
    }

}
