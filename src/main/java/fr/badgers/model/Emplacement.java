package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Emplacement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int numEmpl;
	private EmplacementType emplType;
	private Hulk hulk;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numEmpl;
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
		Emplacement other = (Emplacement) obj;
		if (numEmpl != other.numEmpl)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emplacement [numEmpl=" + numEmpl + ", emplType=" + emplType
				+ ", hulk=" + hulk + "]";
	}

	public int getNumEmpl() {
		return numEmpl;
	}

	public void setNumEmpl(int numEmpl) {
		this.numEmpl = numEmpl;
	}

	public EmplacementType getEmplType() {
		return emplType;
	}

	public void setEmplType(EmplacementType emplType) {
		this.emplType = emplType;
	}

	public Hulk getHulk() {
		return hulk;
	}

	public void setHulk(Hulk hulk) {
		this.hulk = hulk;
	}

	public Emplacement()
	{
		
	}

}
