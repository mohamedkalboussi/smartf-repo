package org.glsid.service;

import java.util.List;

import org.glsid.entities.Employe;
import org.glsid.metier.IEmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {

	@Autowired
	private IEmployeMetier employeMetier;

	@RequestMapping(value="/employes", method=RequestMethod.GET)
	//@ResponseBody
	public List<Employe> findAll() {
		return employeMetier.findAll();
	}

	@RequestMapping(value="/employes", method=RequestMethod.POST)
	//@ResponseBody
	public Employe save(@RequestBody Employe c) {  // "@RequestBody" : l'employe à sauvegarder  
		return employeMetier.save(c);			 //  doit être envoyé au format JSON,
	}											 //	 dans le corps de la requête
}
