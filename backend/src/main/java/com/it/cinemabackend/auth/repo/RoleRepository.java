package com.it.cinemabackend.auth.repo;

import com.it.cinemabackend.auth.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}