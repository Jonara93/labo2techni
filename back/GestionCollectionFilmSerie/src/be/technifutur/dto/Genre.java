package be.technifutur.dto;

public class Genre {
	/*
	 * FIELD
	 */

	private Integer ge_id;
	private String ge_nom;

	/*
	 * CONSTRUCTOR
	 */

	public Genre() {
	}

	public Genre(Integer ge_id, String ge_nom) {
		this.ge_id = ge_id;
		this.ge_nom = ge_nom;
	}
	public Genre(Integer ge_id) {
		this.ge_id = ge_id;		
	}

	/*
	 * GETTER SETTER
	 */

	public Integer getGe_id() {
		return ge_id;
	}

	public void setGe_id(Integer ge_id) {
		this.ge_id = ge_id;
	}

	public String getGe_nom() {
		return ge_nom;
	}

	public void setGe_nom(String ge_nom) {
		this.ge_nom = ge_nom;
	}
	/*
	 * METHOD
	 */

	@Override
	public String toString() {
		return "Genre [ge_id=" + ge_id + ", ge_nom=" + ge_nom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ge_id == null) ? 0 : ge_id.hashCode());
		result = prime * result + ((ge_nom == null) ? 0 : ge_nom.hashCode());
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
		Genre other = (Genre) obj;
		if (ge_id == null) {
			if (other.ge_id != null)
				return false;
		} else if (!ge_id.equals(other.ge_id))
			return false;
		if (ge_nom == null) {
			if (other.ge_nom != null)
				return false;
		} else if (!ge_nom.equals(other.ge_nom))
			return false;
		return true;
	}

}
