package ma.emsi.VoitureService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
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
		return voitureRepository.findAll();
	}

	@GetMapping("/voiture/{id}")
	public Voiture chercherUneVoiture(@PathVariable Long id) throws Exception {
		return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
	}

	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
		return args -> {
			Client c1 = clientService.getClientById(2L);
			Client c2 = clientService.getClientById(1L);
			Client c3 = clientService.getClientById(3L);

			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");

			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("**************************");

			System.out.println("**************************");
			System.out.println("Id est :" + c3.getId());
			System.out.println("Nom est :" + c3.getNom());
			System.out.println("**************************");
			System.out.println(c3);

			Voiture v1 = new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", c3.getId(), c3);
			Voiture v2 = new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", c1.getId(), c1);
			Voiture v3 = new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", c2.getId(), c2);

			voitureRepository.save(v1);
			voitureRepository.save(v2);
			voitureRepository.save(v3);
		};
	}
}
