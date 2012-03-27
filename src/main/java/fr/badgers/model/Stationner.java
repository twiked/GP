package fr.badgers.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(StationnerId.class)
public class Stationner implements Serializable {
	private static final long serialVersionUID = 3322017048145475483L;

	@Id
	@ManyToOne
	private Passager passager;

	@Id
	@ManyToOne
	private Emplacement emplacement;

	@Id
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	public Stationner() {
		super();
	}

	public Stationner(Passager passager, Emplacement emplacement, Date dateDebut) {
		this.passager = passager;
		this.emplacement = emplacement;
		this.dateDebut = dateDebut;
	}

	public Passager getPassager() {
		return passager;
	}

	public Emplacement getEmplacement() {
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
		result = prime * result
				+ ((passager == null) ? 0 : passager.hashCode());
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
		Stationner other = (Stationner) obj;
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
		if (passager == null) {
			if (other.passager != null)
				return false;
		} else if (!passager.equals(other.passager))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stationner ["
				+ (passager != null ? "passager=" + passager + ", " : "")
				+ (emplacement != null ? "emplacement=" + emplacement + ", "
						: "")
				+ (dateDebut != null ? "dateDebut=" + dateDebut : "") + "]";
	}

}
