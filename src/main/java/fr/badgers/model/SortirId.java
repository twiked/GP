package fr.badgers.model;

import java.io.Serializable;
import java.util.Date;

public class SortirId implements Serializable{
	private static final long serialVersionUID = -2295089614984036341L;
	private int resident;
	private Date dateDebut;
	public SortirId() {
	}
	
	public SortirId(int resident, Date dateDebut) {
		this.resident = resident;
		this.dateDebut = dateDebut;
	}

	public int getResident() {
		return resident;
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
		result = prime * result + resident;
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
		SortirId other = (SortirId) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (resident != other.resident)
			return false;
		return true;
	}

}
