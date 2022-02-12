package com.kushnirmark.spring.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "semestr_discipline")
public class Semestr_Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "id_semestr")
    int id_semestr;

    @Column(name = "id_discipline")
    int id_discipline;

    public Semestr_Disc() {
    }

    public Semestr_Disc(int id, int id_semestr, int id_discipline) {
        this.id = id;
        this.id_semestr = id_semestr;
        this.id_discipline = id_discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_semestr() {
        return id_semestr;
    }

    public void setId_semestr(int id_semestr) {
        this.id_semestr = id_semestr;
    }

    public int getId_discipline() {
        return id_discipline;
    }

    public void setId_discipline(int id_discipline) {
        this.id_discipline = id_discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr_Disc that = (Semestr_Disc) o;

        if (id != that.id) return false;
        if (id_semestr != that.id_semestr) return false;
        return id_discipline == that.id_discipline;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_semestr;
        result = 31 * result + id_discipline;
        return result;
    }

    @Override
    public String toString() {
        return "Semestr_Disc{" +
                "id=" + id +
                ", id_semestr=" + id_semestr +
                ", id_discipline=" + id_discipline +
                '}';
    }

}
