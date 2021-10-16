package com.it.cinemabackend.auth.service;

import com.it.cinemabackend.auth.domain.model.Role;
import com.it.cinemabackend.auth.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow();
    }
}
