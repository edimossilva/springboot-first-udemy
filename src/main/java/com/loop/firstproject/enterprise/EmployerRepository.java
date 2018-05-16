package com.loop.firstproject.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loop.firstproject.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

}
