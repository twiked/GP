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
@IdClass(SortirId.class)
public class Sortir implements Serializable {
	private static final long serialVersionUID = -2276165032520436222L;

	@Id
	@ManyToOne
	private Resident resident;

	@Id
	@Temporal(TemporalType.DATE)
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	private Date dateRetourPrevu;

	@Temporal(TemporalType.DATE)
	private Date dateRetourReel;

	public Sortir() {
	}

	public Sortir(Resident resident, Date dateDebut) {
		super();
		this.resident = resident;
		this.dateDebut = dateDebut;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateRetourPrevu() {
		return dateRetourPrevu;
	}

	public void setDateRetourPrevu(Date dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}

	public Date getDateRetourReel() {
		return dateRetourReel;
	}

	public void setDateRetourReel(Date dateRetourReel) {
		this.dateRetourReel = dateRetourReel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result
				+ ((dateRetourPrevu == null) ? 0 : dateRetourPrevu.hashCode());
		result = prime * result
				+ ((dateRetourReel == null) ? 0 : dateRetourReel.hashCode());
		result = prime * result
				+ ((resident == null) ? 0 : resident.hashCode());
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
		Sortir other = (Sortir) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateRetourPrevu == null) {
			if (other.dateRetourPrevu != null)
				return false;
		} else if (!dateRetourPrevu.equals(other.dateRetourPrevu))
			return false;
		if (dateRetourReel == null) {
			if (other.dateRetourReel != null)
				return false;
		} else if (!dateRetourReel.equals(other.dateRetourReel))
			return false;
		if (resident == null) {
			if (other.resident != null)
				return false;
		} else if (!resident.equals(other.resident))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sortir ["
				+ (resident != null ? "resident=" + resident + ", " : "")
				+ (dateDebut != null ? "dateDebut=" + dateDebut + ", " : "")
				+ (dateRetourPrevu != null ? "dateRetourPrevu="
						+ dateRetourPrevu + ", " : "")
				+ (dateRetourReel != null ? "dateRetourReel=" + dateRetourReel
						: "") + "]";
	}

}
