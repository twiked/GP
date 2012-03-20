package fr.badgers.model;

import javax.persistence.*;

@Entity
public class Model {

	@Id
	private int modId;
	private String serie;
	private String type;
	private String constructor;
	private int modLength;
	private int modWidth;
	private int modDraft;
	
	public Model()
	{
		
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConstructor() {
		return constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public int getModLength() {
		return modLength;
	}

	public void setModLength(int modLength) {
		this.modLength = modLength;
	}

	public int getModWidth() {
		return modWidth;
	}

	public void setModWidth(int modWidth) {
		this.modWidth = modWidth;
	}

	public int getModDraft() {
		return modDraft;
	}

	public void setModDraft(int modDraft) {
		this.modDraft = modDraft;
	}

	@Override
	public String toString() {
		return "Model [modId=" + modId + ", serie=" + serie + ", type=" + type
				+ ", constructor=" + constructor + ", modLength=" + modLength
				+ ", modWidth=" + modWidth + ", modDraft=" + modDraft + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + modId;
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
		Model other = (Model) obj;
		if (modId != other.modId)
			return false;
		return true;
	}
	
	
}
