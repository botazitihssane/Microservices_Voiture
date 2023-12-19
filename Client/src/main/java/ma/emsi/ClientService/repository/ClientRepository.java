package ma.emsi.ClientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.ClientService.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
