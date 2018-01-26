package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Client;

public interface IClientMetier {

	List<Client> findAll();
	Client save(Client c);
}
