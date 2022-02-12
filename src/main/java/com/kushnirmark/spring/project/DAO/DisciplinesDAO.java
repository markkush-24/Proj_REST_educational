package com.kushnirmark.spring.project.DAO;

import com.kushnirmark.spring.project.entity.Discipline;

import java.util.List;

public interface DisciplinesDAO {
    List<Discipline> getAllDisciplines();

    void saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

    List<Discipline> getDisciplineList(List<Integer> id);
}
