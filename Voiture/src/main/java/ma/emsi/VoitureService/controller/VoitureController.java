package ma.emsi.VoitureService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ma.emsi.VoitureService.model.Client;
import ma.emsi.VoitureService.model.Voiture;
import ma.emsi.VoitureService.repository.VoitureRepository;
import ma.emsi.VoitureService.service.ClientService;

@Controller
public class VoitureController {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ClientService clientService;

	@GetMapping("/voitures")
	public String chercherVoitures(Model model) {
		List<Voiture> voitures = voitureRepository.findAll();
		model.addAttribute("voitures", voitures);
		return "voitures";
	}

	@GetMapping("/ajouter-voiture")
	public String ajoutForm(Voiture voiture) {
		return "ajouter-voiture";
	}

	@PostMapping("/ajouter-voiture")
	public String ajouterVoiture(@ModelAttribute("voiture") Voiture voiture, Model model) {
		try {
			voitureRepository.save(voiture);
			return "redirect:/voitures";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error adding the voiture: " + e.getMessage());
			return "ajouter-voiture";
		}
	}

	@GetMapping("/supprimer-voiture/{id}")
	public String supprimerVoiture(@PathVariable Long id) {
		voitureRepository.deleteById(id);
		return "redirect:/voitures";
	}

	@GetMapping("/voiture/{id}")
	public Voiture chercherUneVoiture(@PathVariable Long id) throws Exception {
		return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
	}

}
