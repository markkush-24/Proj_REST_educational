package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsDAOImpl implements StudentsDAO {
    @Autowired
    //Внедряем зависимость от sessionFactory в наш класс StudentsDAOImpl
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        //запрос из БД для получения студентов
        List<Student> allStudents = session.createQuery("from Student", Student.class).getResultList();
        return allStudents;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("delete  from Student where id =:studentId ");
        query.setParameter("studentId",id);
        query.executeUpdate();
    }

    @Override
    public List<Discipline> getDisciplinesStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Discipline>query = session.createQuery("select a.discipline from Mark b inner join" +
                " Discipline a on b.id_discipline = a.id" +
                " inner join Semestr_Disc c on a.id = c.id_discipline where c.id_semestr = 2 and b.id_student =:studId");
        query.setParameter("studId",id);
        return query.getResultList();
    }

    @Override
    public List<Discipline> getDisciplinesStudentSemester(int idStud, int idSem) {
        Session session = sessionFactory.getCurrentSession();
        Query<Discipline>query = session.createQuery("select a.discipline from Mark b inner join" +
                " Discipline a on b.id_discipline = a.id" +
                " inner join Semestr_Disc c on a.id = c.id_discipline where c.id_semestr =:semId and b.id_student =:studId");
        query.setParameter("studId",idStud);
        query.setParameter("semId",idSem);
        return query.getResultList();
    }


}
