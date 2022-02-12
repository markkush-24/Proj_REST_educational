package com.kushnirmark.spring.project.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semestr")
public class Semestr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "status")
    @Type(type="boolean")
    private Boolean status = true;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "semestr_discipline",
            joinColumns = @JoinColumn(name = "id_semestr"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline")
    )
    private List<Discipline> disciplineList;


    public void addDisciplineToSemester(Discipline discipline) {
        if (disciplineList == null) {
            disciplineList = new ArrayList<>();
        }
        disciplineList.add(discipline);
    }

    public Semestr() {
    }

    public Semestr(int id, String name, String duration, boolean status) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr semestr = (Semestr) o;

        if (id != semestr.id) return false;
        if (status != semestr.status) return false;
        if (name != null ? !name.equals(semestr.name) : semestr.name != null) return false;
        return duration != null ? duration.equals(semestr.duration) : semestr.duration == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Semestr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                '}';
    }
}
