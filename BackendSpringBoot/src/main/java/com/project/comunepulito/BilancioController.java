package com.project.comunepulito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BilancioController {
	@Autowired
	private UtenteRepository utenteRepository;
	
	@GetMapping("/bilancio")
	public Integer Bilancio(@RequestParam Integer id) {
		return utenteRepository.findById(id).get().getBilancio();
	}
}
