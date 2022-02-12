package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SemestrImpl implements SemestrDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Semestr> getSemestr() {
        Session session = sessionFactory.getCurrentSession();
        List<Semestr> semestrs = session.createQuery("from Semestr", Semestr.class).getResultList();
        return semestrs;
    }

    @Override
    public List<Discipline> getDisciplineSemestr() {
        Session session = sessionFactory.getCurrentSession();
        List<Discipline> discSem = session.createQuery("select a.discipline from Discipline a" +
                " inner join Semestr_Disc b on a.id=b.id_discipline where b.id_semestr = 1 ").getResultList();
        return discSem;
    }

    @Override
    public List<Discipline> getDisciplineSemestrId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Discipline> query = session.createQuery("select a.discipline from" +
                " Discipline a inner join Semestr_Disc b on a.id=b.id_discipline where b.id_semestr =:semId");
        query.setParameter("semId", id);
        return query.getResultList();


    }


    @Override
    public void saveNewSemester(Semestr semestr) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(semestr);
    }

    @Override
    public void deleteSemestr(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Semestr> query = session.createQuery("delete  from Semestr where id =:semestrId ");
        query.setParameter("semestrId", id);
        query.executeUpdate();
    }

}
