package badgers.model;

public class Owner {
	
	private int numOwn;
	private String nameOwn;
	private String addrOwn;
	private String telOwn;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOwn;
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
		Owner other = (Owner) obj;
		if (numOwn != other.numOwn)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Owner [numOwn=" + numOwn + ", nameOwn=" + nameOwn
				+ ", addrOwn=" + addrOwn + ", telOwn=" + telOwn + "]";
	}



	public int getNumOwn() {
		return numOwn;
	}



	public void setNumOwn(int numOwn) {
		this.numOwn = numOwn;
	}



	public String getNameOwn() {
		return nameOwn;
	}



	public void setNameOwn(String nameOwn) {
		this.nameOwn = nameOwn;
	}



	public String getAddrOwn() {
		return addrOwn;
	}



	public void setAddrOwn(String addrOwn) {
		this.addrOwn = addrOwn;
	}



	public String getTelOwn() {
		return telOwn;
	}



	public void setTelOwn(String telOwn) {
		this.telOwn = telOwn;
	}



	public Owner()
	{
		
	}

}
