package model;

import java.io.Serializable;

public class Boat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6405580716160297097L;

	private String boatName;
	private int serialNum;
	private String insurance;
	
	@Override
	public String toString() {
		return "Boat [boatName=" + boatName + ", serialNum=" + serialNum
				+ ", insurance=" + insurance + "]";
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