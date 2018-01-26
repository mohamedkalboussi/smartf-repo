package org.glsid.metier;

import org.glsid.dao.CompteRepository;
import org.glsid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  	// or "@Component"
public class CompteMetierImpl implements ICompteMetier {

	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte findByCode(String code) {
		return compteRepository.findOne(code);
	}

	@Override
	public Compte save(Compte c) {
		return compteRepository.save(c);
	}
}
