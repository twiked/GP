package fr.badgers.model;

import javax.persistence.*;

@Entity
public class Hulk {
	
	@Id
	private int hulkId;
	private String hulkName;
	private String pondName;
	private boolean reserved;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hulkId;
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
		Hulk other = (Hulk) obj;
		if (hulkId != other.hulkId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Hulk [hulkId=" + hulkId + ", hulkName=" + hulkName
				+ ", pondName=" + pondName + ", reserved=" + reserved + "]";
	}



	public int getHulkId() {
		return hulkId;
	}



	public void setHulkId(int hulkId) {
		this.hulkId = hulkId;
	}



	public String getHulkName() {
		return hulkName;
	}



	public void setHulkName(String hulkName) {
		this.hulkName = hulkName;
	}



	public String getPondName() {
		return pondName;
	}



	public void setPondName(String pondName) {
		this.pondName = pondName;
	}



	public boolean isReserved() {
		return reserved;
	}



	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}



	public Hulk()
	{
		
	}

}
