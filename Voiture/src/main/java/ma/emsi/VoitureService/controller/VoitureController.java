package ma.emsi.VoitureService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.VoitureService.model.Client;
import ma.emsi.VoitureService.model.Voiture;
import ma.emsi.VoitureService.repository.VoitureRepository;
import ma.emsi.VoitureService.service.ClientService;

@RestController
public class VoitureController {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ClientService clientService;

	@GetMapping("/voitures")
	public List<Voiture> chercherVoitures() {
		List<Voiture> voitures = voitureRepository.findAll();
		List<Voiture> result = new ArrayList<>();
		voitures.forEach(voiture -> {
			Long clientId = voiture.getId_client();
			Client client = clientService.getClientById(clientId);
			voiture.setClient(client);
			result.add(voiture);
		});
		return result;
	}

	@GetMapping("/voiture/{id}")
	public Voiture chercherUneVoiture(@PathVariable Long id) throws Exception {
		return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
	}

}
