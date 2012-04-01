package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Modele implements Serializable {
	private static final long serialVersionUID = -3392722032330166050L;

	@Id
	@GeneratedValue
	private int idModele;

	private String serie;
	private String type;

	private String constructeur;
	private int longueur;
	private int largeur;
	private int tirant;

	public Modele() {
		super();
	}

	public Modele(int idModele) {
		super();
		this.idModele = idModele;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getTirant() {
		return tirant;
	}

	public void setTirant(int tirant) {
		this.tirant = tirant;
	}

	public int getIdModele() {
		return idModele;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + largeur;
		result = prime * result + longueur;
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result + tirant;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + idModele;
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
		Modele other = (Modele) obj;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (largeur != other.largeur)
			return false;
		if (longueur != other.longueur)
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (tirant != other.tirant)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (idModele != other.idModele)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modele "
				+ idModele
				+ " - "
				+ (serie != null ? serie + " - " : "")
				+ (type != null ? type : "");
	}

}
