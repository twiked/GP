package fr.badgers.model;

import java.io.Serializable;
import java.util.Date;

public class OccuperId implements Serializable {
	private static final long serialVersionUID = 1221328439971858588L;
	private Date dateDebut;
	private int resident;
	private EmplacementId emplacement;

	public OccuperId() {
		super();
	}

	public OccuperId(Date dateDebut, int resident, EmplacementId emplacement) {
		super();
		this.dateDebut = dateDebut;
		this.resident = resident;
		this.emplacement = emplacement;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public int getResident() {
		return resident;
	}

	public EmplacementId getEmplacement() {
		return emplacement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result
				+ ((emplacement == null) ? 0 : emplacement.hashCode());
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
		OccuperId other = (OccuperId) obj;
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
		if (resident != other.resident)
			return false;
		return true;
	}

}
