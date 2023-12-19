package ma.emsi.VoitureService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.VoitureService.model.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
