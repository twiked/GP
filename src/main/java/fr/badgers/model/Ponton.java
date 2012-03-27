package fr.badgers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ponton implements Serializable {
	private static final long serialVersionUID = 3375003727758242143L;
	
	@Id
	private int idPonton;
	
    private String bassin;
    private String ponton;
    private boolean reserve;
    
    public Ponton() {
		super();
	}

	public Ponton(int idPonton) {
		super();
		this.idPonton = idPonton;
	}

	public String getBassin() {
		return bassin;
	}

	public void setBassin(String bassin) {
		this.bassin = bassin;
	}

	public String getPonton() {
		return ponton;
	}

	public void setPonton(String ponton) {
		this.ponton = ponton;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public int getIdPonton() {
		return idPonton;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bassin == null) ? 0 : bassin.hashCode());
		result = prime * result + idPonton;
		result = prime * result + ((ponton == null) ? 0 : ponton.hashCode());
		result = prime * result + (reserve ? 1231 : 1237);
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
		Ponton other = (Ponton) obj;
		if (bassin == null) {
			if (other.bassin != null)
				return false;
		} else if (!bassin.equals(other.bassin))
			return false;
		if (idPonton != other.idPonton)
			return false;
		if (ponton == null) {
			if (other.ponton != null)
				return false;
		} else if (!ponton.equals(other.ponton))
			return false;
		if (reserve != other.reserve)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ponton [idPonton=" + idPonton + ", "
				+ (bassin != null ? "bassin=" + bassin + ", " : "")
				+ (ponton != null ? "ponton=" + ponton + ", " : "")
				+ "reserve=" + reserve + "]";
	}
    

}

