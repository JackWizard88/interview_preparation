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

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestParam(defaultValue = "null") Long id, @RequestParam String name, @RequestParam Integer age) {
        Student student;
        if (id != null) {
            student = studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("no user with provided id found"));
            student.setAge(age);
            student.setName(name);
        } else {
            student = new Student(name, age);
        }

        studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentById(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("no user with provided id found")));
        return "students_edit";
    }

}
