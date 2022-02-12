package com.kushnirmark.spring.project.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "status")
    @Type(type = "boolean")
    private Boolean status = true;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "semestr_discipline",
            joinColumns = @JoinColumn(name = "id_discipline"),
            inverseJoinColumns = @JoinColumn(name = "id_semestr")
    )
    private List<Semestr> semestrList;

    public void addSemesterToDiscipline(Semestr semestr) {
        if (semestrList == null) {
            semestrList = new ArrayList<>();
        }
        semestrList.add(semestr);
    }

    public Discipline() {

    }


    public Discipline(int id, String discipline, boolean status) {
        this.id = id;
        this.discipline = discipline;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Semestr> getSemestrList() {
        return semestrList;
    }

    public void setSemestrList(List<Semestr> semestrList) {
        this.semestrList = semestrList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(discipline, that.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discipline, status);
    }


    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", discipline='" + discipline + '\'' +
                ", status=" + status +
                '}';
    }
}
