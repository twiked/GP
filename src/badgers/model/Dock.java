package badgers.model;

public class Dock {
	
	private int codeDock;
	private String nameDock;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeDock;
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
		Dock other = (Dock) obj;
		if (codeDock != other.codeDock)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Dock [codeDock=" + codeDock + ", nameDock=" + nameDock + "]";
	}



	public int getCodeDock() {
		return codeDock;
	}



	public void setCodeDock(int codeDock) {
		this.codeDock = codeDock;
	}



	public String getNameDock() {
		return nameDock;
	}



	public void setNameDock(String nameDock) {
		this.nameDock = nameDock;
	}



	public Dock()
	{
		
	}

}
