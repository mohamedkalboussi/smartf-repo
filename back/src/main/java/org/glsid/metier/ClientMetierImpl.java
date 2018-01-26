package org.glsid.metier;

import java.util.List;

import org.glsid.dao.ClientRepository;
import org.glsid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  	// or "@Component"
public class ClientMetierImpl implements IClientMetier {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client save(Client c) {
		return clientRepository.save(c);
	}

}
