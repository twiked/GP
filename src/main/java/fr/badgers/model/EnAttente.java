package fr.badgers.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EnAttente extends Bateau implements Serializable {
	private static final long serialVersionUID = 4674296304879764376L;

	@Temporal(TemporalType.DATE)
	private Date dateDemande;
	private int rang;
	private int dureeOccupationPrevue;

	public EnAttente() {
	}

	public EnAttente(int idBateau) {
		super(idBateau);
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public int getDureeOccupationPrevue() {
		return dureeOccupationPrevue;
	}

	public void setDureeOccupationPrevue(int dureeOccupationPrevue) {
		this.dureeOccupationPrevue = dureeOccupationPrevue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dateDemande == null) ? 0 : dateDemande.hashCode());
		result = prime * result + dureeOccupationPrevue;
		result = prime * result + rang;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnAttente other = (EnAttente) obj;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (dureeOccupationPrevue != other.dureeOccupationPrevue)
			return false;
		if (rang != other.rang)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnAttente [" + super.toString() + "]";
	}

}
