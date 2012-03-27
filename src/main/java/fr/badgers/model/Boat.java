package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Boat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6405580716160297097L;

	private String boatName;
	@Id
	private int serialNum;
	private String insurance;
	
	@ManyToOne
	private Model boatModel;
	@ManyToOne
	private Owner boatOwner;
	@ManyToOne
	private Dock boatDock;
	
	
	
	public Model getBoatModel() {
		return boatModel;
	}

	public void setBoatModel(Model boatModel) {
		this.boatModel = boatModel;
	}

	public Owner getBoatOwner() {
		return boatOwner;
	}

	public void setBoatOwner(Owner boatOwner) {
		this.boatOwner = boatOwner;
	}

	public Dock getBoatDock() {
		return boatDock;
	}

	public void setBoatDock(Dock boatDock) {
		this.boatDock = boatDock;
	}

	@Override
	public String toString() {
		return "Boat [boatName=" + boatName + ", serialNum=" + serialNum
				+ ", insurance=" + insurance + ", boatModel=" + boatModel
				+ ", boatOwner=" + boatOwner + ", boatDock=" + boatDock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((boatName == null) ? 0 : boatName.hashCode());
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
		Boat other = (Boat) obj;
		if (boatName == null) {
			if (other.boatName != null)
				return false;
		} else if (!boatName.equals(other.boatName))
			return false;
		return true;
	}

	public String getBoatName() {
		return boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public Boat() {

	}

	
}