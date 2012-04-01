package fr.badgers.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@IdClass(EmplacementId.class)
public class Emplacement implements Serializable {
	private static final long serialVersionUID = 3139592152363061711L;

	@Id
    @ManyToOne
    private Ponton ponton;

    @Id
    @Column(name="NUMEMPL")
    private int numeroEmplacement;

    @ManyToOne
    private TypeEmplacement type;
    
    @OneToMany(targetEntity=Occuper.class, mappedBy="emplacement")
    private Collection<Occuper> occupe;

    @OneToMany(targetEntity=Stationner.class, mappedBy="emplacement")
    private Collection<Stationner> stationne;

	public Emplacement(Ponton ponton, int numeroEmplacement) {
		super();
		this.ponton = ponton;
		this.numeroEmplacement = numeroEmplacement;
	}

	public Emplacement() {
		super();
	}

	public TypeEmplacement getType() {
		return type;
	}

	public void setType(TypeEmplacement type) {
		this.type = type;
	}

	public Collection<Occuper> getOccupe() {
		return occupe;
	}

	public void setOccupe(Collection<Occuper> occupe) {
		this.occupe = occupe;
	}

	public Collection<Stationner> getStationne() {
		return stationne;
	}

	public void setStationne(Collection<Stationner> stationne) {
		this.stationne = stationne;
	}

	public Ponton getPonton() {
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
		result = prime * result + ((ponton == null) ? 0 : ponton.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (numeroEmplacement != other.numeroEmplacement)
			return false;
		if (ponton == null) {
			if (other.ponton != null)
				return false;
		} else if (!ponton.equals(other.ponton))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 5;
		return "Emplacement ["
				+ (ponton != null ? "ponton=" + ponton + ", " : "")
				+ "numeroEmplacement="
				+ numeroEmplacement
				+ ", "
				+ (type != null ? "type=" + type + ", " : "")
				+ (occupe != null ? "occupe=" + toString(occupe, maxLen) + ", "
						: "")
				+ (stationne != null ? "stationne="
						+ toString(stationne, maxLen) : "") + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
    
    
   
}

