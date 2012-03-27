package fr.badgers.model;

import java.io.Serializable;

public class EmplacementId implements Serializable{
	private static final long serialVersionUID = -7265481903141674761L;
	
	private int ponton;
    private int numeroEmplacement;
	
    public EmplacementId() {
	}

	public EmplacementId(int ponton, int numeroEmplacement) {
		this.ponton = ponton;
		this.numeroEmplacement = numeroEmplacement;
	}

	public int getPonton() {
		return ponton;
	}

	public int getNumeroEmplacement() {
		return numeroEmplacement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroEmplacement;
		result = prime * result + ponton;
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
		EmplacementId other = (EmplacementId) obj;
		if (numeroEmplacement != other.numeroEmplacement)
			return false;
		if (ponton != other.ponton)
			return false;
		return true;
	}
	
	
    
}
