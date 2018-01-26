package org.glsid.service;

import java.util.List;

import org.glsid.entities.Client;
import org.glsid.metier.IClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {

	@Autowired
	private IClientMetier clientMetier;

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	//@ResponseBody
	public List<Client> findAll() {
		return clientMetier.findAll();
	}

	@RequestMapping(value="/clients", method=RequestMethod.POST)
	//@ResponseBody
	public Client save(@RequestBody Client c) {  // "@RequestBody" : le client à sauvegarder  
		return clientMetier.save(c);			 //  doit être envoyé au format JSON,
	}											 //	 dans le corps de la requête
}
