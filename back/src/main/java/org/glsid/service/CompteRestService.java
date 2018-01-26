package org.glsid.service;

import org.glsid.entities.Compte;
import org.glsid.metier.ICompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {

	@Autowired
	private ICompteMetier compteMetier;

	@RequestMapping(value="/comptes/{code}", method=RequestMethod.GET)
	//@ResponseBody
	public Compte findByCode(@PathVariable String code) {
		return compteMetier.findByCode(code);
	}

	@RequestMapping(value="/comptes", method=RequestMethod.POST)
	//@ResponseBody
	public Compte save(@RequestBody Compte c) {  // "@RequestBody" : le compte à sauvegarder  
		return compteMetier.save(c);			 //  doit être envoyé au format JSON,
	}											 //	 dans le corps de la requête
}
