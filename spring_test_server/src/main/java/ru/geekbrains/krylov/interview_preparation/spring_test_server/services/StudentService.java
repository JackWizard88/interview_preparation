package ru.geekbrains.krylov.interview_preparation.spring_test_server.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.entities.Student;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentsRepository studentsRepository;

    public Optional<Student> findById(Long id) {
        return studentsRepository.findById(id);
    }

    public List<Student> findAll() { return  studentsRepository.findAll();}

    public Student saveOrUpdate(Student student) {
        return studentsRepository.save(student);
    }

    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }

}
