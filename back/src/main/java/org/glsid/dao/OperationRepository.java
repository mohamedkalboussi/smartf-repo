package org.glsid.dao;

import org.glsid.entities.Compte;
import org.glsid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	// 1ère solution
	@Query("select o from Operation o where o.compte.codeCompte = :x")
	Page<Operation> getOperations(@Param("x") String codeCompte, Pageable pageable);
	
	// 2ème solution
	Page<Operation> findByCompte(Compte c, Pageable pageable);
}
	