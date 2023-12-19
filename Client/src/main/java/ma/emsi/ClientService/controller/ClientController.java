package ma.emsi.ClientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
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
	public List chercherClients() {
		return clientRepository.findAll();
	}

	@GetMapping("/client/{id}")
	public Client chercherUnClients(@PathVariable Long id) throws Exception {

		return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistnt"));
	}
	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
	    return args -> {
	       clientRepository.save(new Client(Long.parseLong("1"), "Rabab FAHSSI", Float.parseFloat("23")));
	       clientRepository.save(new Client(Long.parseLong("2"), "Houda EL KORAINI", Float.parseFloat("22")));
	       clientRepository.save(new Client(Long.parseLong("3"), "Saad BAKANZIZE", Float.parseFloat("22")));

	    };
	}

}