package fr.badgers.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proprietaire implements Serializable
{
	private static final long serialVersionUID = 607512108525066212L;
	
	@Id
	@GeneratedValue
	private int idProprietaire;
	private String nom;
	private String adresse;
	private String telephone;

	@OneToMany(targetEntity=Bateau.class,mappedBy="proprietaire")
	private Collection<Bateau> bateaux;

	public Proprietaire() {
		super();
	}

	public Proprietaire(int idProprietaire) {
		super();
		this.idProprietaire = idProprietaire;
	}

	public int getIdProprietaire() {
		return idProprietaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Collection<Bateau> getBateaux() {
		return bateaux;
	}

	public void setBateaux(Collection<Bateau> bateaux) {
		this.bateaux = bateaux;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + idProprietaire;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
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
		Proprietaire other = (Proprietaire) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (idProprietaire != other.idProprietaire)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proprietaire [idProprietaire=" + idProprietaire + ", "
				+ (nom != null ? "nom=" + nom + ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "")
				+ (telephone != null ? "telephone=" + telephone : "") + "]";
	}
	
	
}
