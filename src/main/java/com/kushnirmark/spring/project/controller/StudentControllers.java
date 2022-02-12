package com.kushnirmark.spring.project.controller;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;
import com.kushnirmark.spring.project.entity.Student;
import com.kushnirmark.spring.project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentControllers {

    @Autowired
    private Service service;

    @RequestMapping(value = "/allStudents", method = RequestMethod.GET)
    public String showAllStudents(Model model) {
        List<Student> allStudents = service.getAllStudents();
        model.addAttribute("allStud", allStudents);
        return "all-students";
    }

    @RequestMapping(value = "/creteNewStudent", method = RequestMethod.GET)
    public String creteNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-create";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.PUT)
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);

        return "redirect:/allStudents";
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(@RequestParam("studId") int id, Model model) {
        Student student = service.getStudent(id);
        model.addAttribute("student", student);
        return "student-create";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam("studId") int id) {
        service.deleteStudent(id);
        return "redirect:/allStudents";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showTitlePage() {
        return "/home";
    }

    @RequestMapping("/studentProgress")
    public String showStudentProgress(@RequestParam("studId") int id, Model model) {
        Student student = service.getStudent(id);
        model.addAttribute("student", student);
        List<Discipline>dis = service.getDisciplinesStudent(id);
        model.addAttribute("Disc",dis);
        List<Semestr> semestr = service.getSemestr();
        model.addAttribute("semestr", semestr);
        return "student-progress";
    }

    @RequestMapping("/studentProgressSem")
    public String showStudentProgress(@ModelAttribute(name = "student") Integer id,
                                      @RequestParam(name = "selectSemestr") String selectSemestr, Model model) {
        Student student = service.getStudent(id);
        model.addAttribute("student", student);
        List<Discipline>dis = service.getDisciplinesStudentSemester(student.getId(),Integer.valueOf(selectSemestr));
        model.addAttribute("Disc",dis);
        List<Semestr> semestr = service.getSemestr();
        model.addAttribute("semestr", semestr);
        return "student-progress";
    }
}
