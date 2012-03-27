package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bateau implements Serializable {
	private static final long serialVersionUID = -7144240030283773695L;
	
	@Id
	@GeneratedValue
	private int idBateau;
	private String nomBateau;
    private int numeroSerie;
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

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
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
		result = prime * result + numeroSerie;
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
		if (numeroSerie != other.numeroSerie)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bateau [idBateau=" + idBateau + ", "
				+ (nomBateau != null ? "nomBateau=" + nomBateau + ", " : "")
				+ "numeroSerie=" + numeroSerie + ", "
				+ (assurance != null ? "assurance=" + assurance : "") + "]";
	}   
	
}