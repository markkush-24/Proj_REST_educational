package com.kushnirmark.spring.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "mark")
    private double mark;
    @Column(name = "id_student")
    private int id_student;
    @Column(name = "id_discipline")
    private int id_discipline;

    public Mark() {
    }

    public Mark(int id, double mark, int id_student, int id_discipline) {
        this.id = id;
        this.mark = mark;
        this.id_student = id_student;
        this.id_discipline = id_discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_discipline() {
        return id_discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (id != mark1.id) return false;
        if (Double.compare(mark1.mark, mark) != 0) return false;
        if (id_student != mark1.id_student) return false;
        return id_discipline == mark1.id_discipline;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(mark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id_student;
        result = 31 * result + id_discipline;
        return result;
    }

    public void setId_discipline(int id_discipline) {
        this.id_discipline = id_discipline;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", mark=" + mark +
                ", id_student=" + id_student +
                ", id_discipline=" + id_discipline +
                '}';
    }
}
