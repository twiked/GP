package fr.badgers.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Passager extends Bateau implements Serializable {
	private static final long serialVersionUID = 8208820473065730189L;

	@OneToMany(targetEntity = Stationner.class, mappedBy = "passager")
	private Collection<Stationner> stationne;

	@ManyToOne
	private Port provenance;

	@ManyToOne
	private Port destination;

	public Passager() {
	}

	public Passager(int idBateau) {
		super(idBateau);
	}

	public Collection<Stationner> getStationne() {
		return stationne;
	}

	public void setStationne(Collection<Stationner> stationne) {
		this.stationne = stationne;
	}

	public Port getProvenance() {
		return provenance;
	}

	public void setProvenance(Port provenance) {
		this.provenance = provenance;
	}

	public Port getDestination() {
		return destination;
	}

	public void setDestination(Port destination) {
		this.destination = destination;
	}
}
