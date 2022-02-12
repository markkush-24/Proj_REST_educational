package com.kushnirmark.spring.project.controller;

import com.kushnirmark.spring.project.entity.Discipline;
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
public class DisciplineControllers {

    @Autowired
    private Service service;


    @RequestMapping(value = "/allDisciplines" , method = RequestMethod.GET)
    public String showAllDisciplines(Model model) {
        List<Discipline> allDisciplines = service.getAllDisciplines();
        model.addAttribute("allDisc", allDisciplines);
        return "disciplines";
    }

    @RequestMapping(value = "/creteNewDiscipline" , method = RequestMethod.POST)
    public String creteNewDiscipline(Model model) {
        Discipline discipline = new Discipline();
        model.addAttribute("discipline", discipline);
        return "discipline-create";
    }

    @RequestMapping(value = "/saveDiscipline", method = RequestMethod.PUT)
    public String saveDiscipline(@ModelAttribute("discipline") Discipline discipline) {
        service.saveDiscipline(discipline);

        return "redirect:/allDisciplines";
    }

    @RequestMapping(value = "/updateDiscipline" , method = RequestMethod.POST)
    public String updateDiscipline(@RequestParam("discId") int id, Model model) {
        Discipline discipline = service.getDiscipline(id);
        model.addAttribute("discipline", discipline);
        return "discipline-create";
    }

    @RequestMapping(value = "/deleteDiscipline" , method = RequestMethod.DELETE)
    public String deleteDiscipline(@RequestParam("discId") int id) {
        service.deleteDiscipline(id);
        return "redirect:/allDisciplines";

    }
}
