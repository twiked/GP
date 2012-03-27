package fr.badgers.model;

import java.io.Serializable;
import java.util.Date;

public class StationnerId implements Serializable{
	private static final long serialVersionUID = -3484128587525320081L;
	
	private int passager;
	private EmplacementId emplacement;
	private Date dateDebut;
	
	public StationnerId() {
	}

	public StationnerId(int passager, EmplacementId emplacement, Date dateDebut) {
		this.passager = passager;
		this.emplacement = emplacement;
		this.dateDebut = dateDebut;
	}

	public int getPassager() {
		return passager;
	}

	public EmplacementId getEmplacement() {
		return emplacement;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result
				+ ((emplacement == null) ? 0 : emplacement.hashCode());
		result = prime * result + passager;
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
		StationnerId other = (StationnerId) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (emplacement == null) {
			if (other.emplacement != null)
				return false;
		} else if (!emplacement.equals(other.emplacement))
			return false;
		if (passager != other.passager)
			return false;
		return true;
	}
}
