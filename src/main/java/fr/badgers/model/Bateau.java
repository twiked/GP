package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Bateau.FIND_BY_NAME, query = "SELECT b FROM Bateau b WHERE b.nomBateau = :fnomBateau"),
    @NamedQuery(name = Bateau.FIND_BY_SERIAL_NUMBER, query = "SELECT b FROM Bateau b WHERE b.numeroSerie = :fnumeroSerie"),
    @NamedQuery(name = Bateau.FIND_BY_MODELE, query = "SELECT b FROM Bateau b WHERE b.modele = :fmodele"),
})
public class Bateau implements Serializable {
	private static final long serialVersionUID = -7144240030283773695L;
	public static final String FIND_BY_NAME = "findBateauxByName";
	public static final String FIND_BY_SERIAL_NUMBER = "findBateauxBySerialNumber";
	public static final String FIND_BY_MODELE = "findBateauxByModele";
	
	@Id
	@GeneratedValue
	private int idBateau;
	private String nomBateau;
    private String numeroSerie;
    private String assurance;
    
    @ManyToOne
	private Modele modele;
	@ManyToOne
	private Port portOrigine;
	@ManyToOne 
	private Proprietaire proprietaire;
	
    public Bateau() {
	}
    
	public Bateau(int idBateau) {
		super();
		this.idBateau = idBateau;
	}


	public String getNomBateau() {
		return nomBateau;
	}

	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getAssurance() {
		return assurance;
	}

	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Port getPortOrigine() {
		return portOrigine;
	}

	public void setPortOrigine(Port portOrigine) {
		this.portOrigine = portOrigine;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getIdBateau() {
		return idBateau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assurance == null) ? 0 : assurance.hashCode());
		result = prime * result + idBateau;
		result = prime * result
				+ ((nomBateau == null) ? 0 : nomBateau.hashCode());
		result = prime * result
				+ ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bateau other = (Bateau) obj;
		if (assurance == null) {
			if (other.assurance != null)
				return false;
		} else if (!assurance.equals(other.assurance))
			return false;
		if (idBateau != other.idBateau)
			return false;
		if (nomBateau == null) {
			if (other.nomBateau != null)
				return false;
		} else if (!nomBateau.equals(other.nomBateau))
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bateau " + idBateau + " - " + nomBateau;
	}   
	
}