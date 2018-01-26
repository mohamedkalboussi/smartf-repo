package org.glsid.service;

import org.glsid.dto.PageOperation;
import org.glsid.metier.IOperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

	@Autowired
	private IOperationMetier operationMetier;

	@RequestMapping(value="/versement", method=RequestMethod.PUT)  // ou bien POST
	public boolean verser(@RequestParam String codeCompte,  // "@RequestParam" : le codeCompte doit être
						  @RequestParam double montant,     // envoyé au format "x-www-form-urlencoded",
						  @RequestParam Long idEmploye) {   // dans le corps de la requête
		return operationMetier.verser(codeCompte, montant, idEmploye);
	}

	@RequestMapping(value="/retrait", method=RequestMethod.PUT)    // ou bien POST
	public boolean retirer(@RequestParam String codeCompte, @RequestParam double montant,
						   @RequestParam Long idEmploye) {
		return operationMetier.retirer(codeCompte, montant, idEmploye);
	}

	@RequestMapping(value="/virement", method=RequestMethod.PUT)   // ou bien POST
	public boolean virement(@RequestParam String codeCompte1, @RequestParam String codeCompte2,
							@RequestParam double montant, @RequestParam Long idEmploye) {
		return operationMetier.virement(codeCompte1, codeCompte2, montant, idEmploye);
	}
	
	@RequestMapping(value="/operations", method=RequestMethod.GET)
	public PageOperation getOperation(@RequestParam String codeCompte,
									  @RequestParam int page, @RequestParam int size) {
		return operationMetier.getOperation(codeCompte, page, size);
	}
}
