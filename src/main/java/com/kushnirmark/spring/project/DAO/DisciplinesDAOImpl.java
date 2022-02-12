package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisciplinesDAOImpl implements DisciplinesDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Discipline> getAllDisciplines() {
        Session session = sessionFactory.getCurrentSession();
        List<Discipline> allDiscipline = session.createQuery("from Discipline", Discipline.class).getResultList();
        return allDiscipline;
    }

    @Override
    public void saveDiscipline(Discipline discipline) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(discipline);
    }

    @Override
    public Discipline getDiscipline(int id) {
        Session session = sessionFactory.getCurrentSession();
        Discipline discipline = session.get(Discipline.class, id);
        return discipline;
    }

    @Override
    public void deleteDiscipline(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Discipline> query = session.createQuery("delete  from Discipline where id =:disciplineId ");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
    }

    @Override
    public List<Discipline> getDisciplineList(List<Integer> id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Discipline> query = session.createQuery("from Discipline  where id in (:IdDisc)", Discipline.class);
        query.setParameter("IdDisc", id);
        return query.getResultList();
    }


}
