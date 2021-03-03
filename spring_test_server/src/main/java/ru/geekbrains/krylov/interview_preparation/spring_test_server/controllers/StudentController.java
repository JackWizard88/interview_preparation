package ru.geekbrains.krylov.interview_preparation.spring_test_server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.entities.Student;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.exceptions.ResourceNotFoundException;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.services.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/find")
    public List<Student> findStudentsByName(@RequestParam String name) {
        return studentService.findAll().stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("no user with provided id found"));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/edit/{id}")
    public String editStudentById(@PathVariable Long id, Model model) {
        model.addAttribute(studentService.findById(id));
        return "/jsp/students_edit.jsp";
    }

}
