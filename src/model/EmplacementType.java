package model;

public class EmplacementType {

	
	private int numType;
	private int typeLength;
	private int typeWidth;
	private int typeDepth;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numType;
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
		EmplacementType other = (EmplacementType) obj;
		if (numType != other.numType)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "EmplacementType [numType=" + numType + ", typeLength="
				+ typeLength + ", typeWidth=" + typeWidth + ", typeDepth="
				+ typeDepth + "]";
	}



	public int getNumType() {
		return numType;
	}



	public void setNumType(int numType) {
		this.numType = numType;
	}



	public int getTypeLength() {
		return typeLength;
	}



	public void setTypeLength(int typeLength) {
		this.typeLength = typeLength;
	}



	public int getTypeWidth() {
		return typeWidth;
	}



	public void setTypeWidth(int typeWidth) {
		this.typeWidth = typeWidth;
	}



	public int getTypeDepth() {
		return typeDepth;
	}



	public void setTypeDepth(int typeDepth) {
		this.typeDepth = typeDepth;
	}



	public EmplacementType()
	{
		
	}
}
