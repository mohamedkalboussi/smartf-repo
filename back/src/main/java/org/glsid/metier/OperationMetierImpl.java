package org.glsid.metier;

import java.util.Date;

import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.OperationRepository;
import org.glsid.dto.PageOperation;
import org.glsid.entities.Compte;
import org.glsid.entities.Employe;
import org.glsid.entities.Operation;
import org.glsid.entities.Retrait;
import org.glsid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  	// or "@Component"
public class OperationMetierImpl implements IOperationMetier {

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	@Transactional     // import org.springframework.transaction.annotation.Transactional;
	public boolean verser(String codeCompte, double montant, Long idEmploye) {
		Compte c = compteRepository.findOne(codeCompte);
		Employe e =employeRepository.findOne(idEmploye);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setEmploye(e);
		operationRepository.save(o);
		c.setSolde(c.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional     // import org.springframework.transaction.annotation.Transactional;
	public boolean retirer(String codeCompte, double montant, Long idEmploye) {
		Compte c = compteRepository.findOne(codeCompte);
		if(c.getSolde()<montant){
			throw new RuntimeException("Solde insuffisant !");
		}
		Employe e =employeRepository.findOne(idEmploye);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(c);
		o.setEmploye(e);
		operationRepository.save(o);
		c.setSolde(c.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional     // import org.springframework.transaction.annotation.Transactional;
	public boolean virement(String codeCompte1, String codeCompte2, double montant, Long idEmploye) {
		retirer(codeCompte1, montant, idEmploye);
		verser(codeCompte2, montant, idEmploye);
		return true;
	}

	@Override
	public PageOperation getOperation(String codeCompte, int page, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		
		PageOperation pOp = new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());  // ou bien pOp.setPage(page);
		pOp.setTotalOperations(ops.getSize());  // ou bien pOp.setTotalOperations(size);
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int) ops.getTotalElements());
		return pOp;
	}
}
