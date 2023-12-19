package ma.emsi.VoitureService.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Voiture {
	@Id
	@GeneratedValue
	private long id;

	private String matricule;

	private String marque;

	private String model;

	private Long id_client;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(long id, String matricule, String marque, String model) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
	}

	public Voiture(long id, String matricule, String marque, String model, Long id_client) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
		this.id_client = id_client;
	}

	public Voiture(long id, String matricule, String marque, String model, Long id_client, Client client) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
		this.id_client = id_client;
		this.client = client;
	}

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
