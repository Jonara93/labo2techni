package be.technifutur.dto;

public class FilmsSeriePersonnesRoles {
	Integer fs_id;
	Integer per_id;
	Integer ro_id;

	public FilmsSeriePersonnesRoles(Integer fs_id, Integer per_id, Integer ro_id) {
		this.fs_id = fs_id;
		this.per_id = per_id;
		this.ro_id = ro_id;
	}

	@Override
	public String toString() {
		return "FilmsSeriePersonnesRoles [fs_id=" + fs_id + ", per_id=" + per_id + ", ro_id=" + ro_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fs_id == null) ? 0 : fs_id.hashCode());
		result = prime * result + ((per_id == null) ? 0 : per_id.hashCode());
		result = prime * result + ((ro_id == null) ? 0 : ro_id.hashCode());
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
		FilmsSeriePersonnesRoles other = (FilmsSeriePersonnesRoles) obj;
		if (fs_id == null) {
			if (other.fs_id != null)
				return false;
		} else if (!fs_id.equals(other.fs_id))
			return false;
		if (per_id == null) {
			if (other.per_id != null)
				return false;
		} else if (!per_id.equals(other.per_id))
			return false;
		if (ro_id == null) {
			if (other.ro_id != null)
				return false;
		} else if (!ro_id.equals(other.ro_id))
			return false;
		return true;
	}

	public Integer getFs_id() {
		return fs_id;
	}

	public void setFs_id(Integer fs_id) {
		this.fs_id = fs_id;
	}

	public Integer getPer_id() {
		return per_id;
	}

	public void setPer_id(Integer per_id) {
		this.per_id = per_id;
	}

	public Integer getRo_id() {
		return ro_id;
	}

	public void setRo_id(Integer ro_id) {
		this.ro_id = ro_id;
	}
}
