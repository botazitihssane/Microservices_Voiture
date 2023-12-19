package ma.emsi.ClientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.ClientService.model.Client;
import ma.emsi.ClientService.repository.ClientRepository;

@RestController
public class ClientController {
	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> chercherClients() {
		return clientRepository.findAll();
	}

	@GetMapping("/client/{id}")
	public Client chercherUnClients(@PathVariable Long id) throws Exception {

		return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistnt"));
	}

}