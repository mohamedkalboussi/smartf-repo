package org.glsid.metier;

import org.glsid.entities.Compte;

public interface ICompteMetier {

	Compte findByCode(String code);
	Compte save(Compte c);
}
