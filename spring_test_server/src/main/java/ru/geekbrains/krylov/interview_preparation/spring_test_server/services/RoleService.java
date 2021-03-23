package ru.geekbrains.krylov.interview_preparation.spring_test_server.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.entities.Role;
import ru.geekbrains.krylov.interview_preparation.spring_test_server.repositories.RoleRepository;

import javax.management.relation.RoleNotFoundException;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByRoleName(String roleName) throws RoleNotFoundException {
        return roleRepository.findByName(roleName).orElseThrow(RoleNotFoundException::new);
    }

}