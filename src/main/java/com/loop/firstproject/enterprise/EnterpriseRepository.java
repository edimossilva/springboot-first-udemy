package com.loop.firstproject.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loop.firstproject.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

	Enterprise findByCnpj(String cnpj);
}
