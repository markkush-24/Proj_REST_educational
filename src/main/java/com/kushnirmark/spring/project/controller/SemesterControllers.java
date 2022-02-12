package com.kushnirmark.spring.project.controller;

import com.kushnirmark.spring.project.entity.Discipline;
import com.kushnirmark.spring.project.entity.Semestr;
import com.kushnirmark.spring.project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SemesterControllers {

    @Autowired
    private Service service;


    @RequestMapping(value = "/allSemestrs", method = RequestMethod.GET)
    public String allSemestrs(Model model) {
        List<Semestr> semestr = service.getSemestr();
        model.addAttribute("semestr", semestr);
        List<Discipline> allDisciplines = service.getDisciplineSemestr();
        model.addAttribute("allDisc", allDisciplines);
        return "semestr";
    }

    @RequestMapping(value = "/allSemestrsSem", method = RequestMethod.GET)
    public String allSemestrs(@RequestParam(name = "selectSemestr") String selectSemestr, Model model) {
        List<Semestr> semestr = service.getSemestr();
        model.addAttribute("semestr", semestr);
        List<Discipline> allDisciplines = service.getDisciplineSemestrId(Integer.valueOf(selectSemestr));
        model.addAttribute("allDisc", allDisciplines);
        return "semestr";
    }


    @RequestMapping(value = "/creteNewSemester", method = RequestMethod.GET)
    public String creteNewSemester(Model model) {
        Semestr semestr = new Semestr();
        model.addAttribute("semestr", semestr);
        List<Discipline> allDisciplines = service.getAllDisciplines();
        model.addAttribute("allDisc", allDisciplines);
        return "create-semestr";
    }

    @RequestMapping("/saveNewSemester")
    public String saveNewSemester(@ModelAttribute("semestr") Semestr semestr,
                                  @RequestParam(name = "AllDiscipline") String[] AllDiscipline,
                                  Model model) {
        List<Integer> list = Arrays.stream(AllDiscipline).map(Integer::parseInt).collect(Collectors.toList());
        List<Discipline> disciplineSemestrList = service.getDisciplineList(list);
        semestr.setDisciplineList(disciplineSemestrList);
        service.saveNewSemester(semestr);
        return "redirect:/allSemestrs";
    }

    @RequestMapping("/deleteSemestr")
    public String deleteSemestr(@RequestParam(name = "selectSemestr") String selectSemestr) {
        service.deleteSemestr(Integer.valueOf(selectSemestr));
        return "redirect:/allSemestrs";
    }
}
