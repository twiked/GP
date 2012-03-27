package fr.badgers.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Resident extends Bateau implements Serializable {
	private static final long serialVersionUID = -8810802507898863916L;

	@OneToMany(targetEntity = Occuper.class, mappedBy = "resident")
	private Collection<Occuper> occuper;

	@OneToMany(targetEntity = Sortir.class, mappedBy = "resident")
	private Collection<Sortir> sortir;

	public Resident() {
	}

	public Resident(int idBateau) {
		super(idBateau);
	}

	public Collection<Occuper> getOccuper() {
		return occuper;
	}

	public void setOccuper(Collection<Occuper> occuper) {
		this.occuper = occuper;
	}

	public Collection<Sortir> getSortir() {
		return sortir;
	}

	public void setSortir(Collection<Sortir> sortir) {
		this.sortir = sortir;
	}

}
