package be.technifutur.dto;

public class Version {
	/*
	 * Field
	 */
	
	private Integer vs_id;
	private String vs_nom;

	/*
	 * Constructor
	 */

	public Version() {
	}

	public Version(Integer vs_id, String vs_nom) {
		this.vs_id = vs_id;
		this.vs_nom = vs_nom;
	}

	public Integer getVs_id() {
		return vs_id;
	}

	public void setVs_id(Integer vs_id) {
		this.vs_id = vs_id;
	}

	/*
	 * Setter and getter
	 */

	public String getVs_nom() {
		return vs_nom;
	}

	public void setVs_nom(String vs_nom) {
		this.vs_nom = vs_nom;
	}

	/*
	 * METHOD
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vs_id == null) ? 0 : vs_id.hashCode());
		result = prime * result + ((vs_nom == null) ? 0 : vs_nom.hashCode());
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
		Version other = (Version) obj;
		if (vs_id == null) {
			if (other.vs_id != null)
				return false;
		} else if (!vs_id.equals(other.vs_id))
			return false;
		if (vs_nom == null) {
			if (other.vs_nom != null)
				return false;
		} else if (!vs_nom.equals(other.vs_nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Version [vs_id=" + vs_id + ", vs_nom=" + vs_nom + "]";
	}
}
