package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Employe;

public interface IEmployeMetier {

	List<Employe> findAll();
	Employe save(Employe e);
}
