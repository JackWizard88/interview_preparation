package ru.geekbrains.krylov.interview_preparation.spring_test_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.entities.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
}
