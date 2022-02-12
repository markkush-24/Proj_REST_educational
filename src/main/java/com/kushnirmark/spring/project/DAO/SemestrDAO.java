package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;

import java.util.List;

public interface SemestrDAO {

    List<Semestr> getSemestr();

    List<Discipline> getDisciplineSemestr();

    List<Discipline> getDisciplineSemestrId(int semId);

    void saveNewSemester(Semestr semestr);

    void deleteSemestr(int id);


}
