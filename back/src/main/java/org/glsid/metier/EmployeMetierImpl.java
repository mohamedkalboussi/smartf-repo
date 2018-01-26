package org.glsid.metier;

import java.util.List;

import org.glsid.dao.EmployeRepository;
import org.glsid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  	// or "@Component"
public class EmployeMetierImpl implements IEmployeMetier {

	@Autowired
	private EmployeRepository employeRepository;
	
	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	@Override
	public Employe save(Employe e) {
		return employeRepository.save(e);
	}

}
