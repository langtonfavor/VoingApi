package com.reactSpringboot1.SpringReactdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactSpringboot1.SpringReactdemo.modal.Role;
import com.reactSpringboot1.SpringReactdemo.modal.RoleName;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
