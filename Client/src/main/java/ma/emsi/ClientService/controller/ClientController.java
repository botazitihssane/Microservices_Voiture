package ma.emsi.ClientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ma.emsi.ClientService.model.Client;
import ma.emsi.ClientService.repository.ClientRepository;

@Controller
public class ClientController {
	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/clients")
	public String chercherClients(Model model) {
		model.addAttribute("clients", clientRepository.findAll());
		return "clients";
	}

	@GetMapping("/client/{id}")
	public Client chercherUnClients(@PathVariable Long id) throws Exception {

		return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistnt"));
	}

	@GetMapping("/ajouter")
	public String ajoutForm(Client client) {
		return "ajouter-client";
	}

	@PostMapping("/ajouter")
	public String ajouterClient(@ModelAttribute("client") Client client, Model model) {
		try {
			clientRepository.save(client);
			return "redirect:/clients";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error adding the client: " + e.getMessage());
			return "ajouter-client";
		}
	}

	@GetMapping("/supprimer/{id}")
	public String supprimerClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		 return "redirect:/clients";
	}

}