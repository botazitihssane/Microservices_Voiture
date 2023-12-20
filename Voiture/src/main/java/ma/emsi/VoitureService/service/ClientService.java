package ma.emsi.VoitureService.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ma.emsi.VoitureService.model.Client;

@FeignClient(name = "service-client")
public interface ClientService {
	@GetMapping("/client/{clientId}")
	Client getClientById(@PathVariable("clientId") Long clientId);

	@GetMapping("/clients")
	List<Client> getAllClient();
}
