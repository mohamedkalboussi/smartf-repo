package org.glsid.metier;

import org.glsid.dto.PageOperation;

public interface IOperationMetier {

	boolean verser(String codeCompte, double montant, Long idEmploye);
	boolean retirer(String codeCompte, double montant, Long idEmploye);
	boolean virement(String codeCompte1, String codeCompte2, double montant, Long idEmploye);
	PageOperation getOperation(String codeCompte, int page, int size);
}
