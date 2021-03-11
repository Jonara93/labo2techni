package be.technifutur.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Personne {

	private Integer per_id;
	private String per_nom;
	private String per_prenom;
	private GenrePers per_genre;
	private LocalDate per_ddn;
	private String per_url;
	private String per_role;

	public Personne() {

	}

	// constructeur
	public Personne(String per_nom, String per_prenom, GenrePers per_genre, LocalDate per_ddn) {
		this.per_nom = per_nom;
		this.per_prenom = per_prenom;
		this.per_genre = per_genre;
		this.per_ddn = per_ddn;
	}

	// constructeur full sans role
	public Personne(Integer per_id, String per_nom, String per_prenom, GenrePers per_genre, LocalDate per_ddn,
			String per_url) {
		this.per_id = per_id;
		this.per_nom = per_nom;
		this.per_prenom = per_prenom;
		this.per_genre = per_genre;
		this.per_ddn = per_ddn;
		this.per_url = per_url;
	}

	// constructeur full avec role
	public Personne(Integer per_id, String per_nom, String per_prenom, GenrePers per_genre, LocalDate per_ddn,
			String per_url, String per_role) {
		this.per_id = per_id;
		this.per_nom = per_nom;
		this.per_prenom = per_prenom;
		this.per_genre = per_genre;
		this.per_ddn = per_ddn;
		this.per_url = per_url;
		this.per_role = per_role;
	}

	

	@Override
	public String toString() {
		return "Personne [per_id=" + per_id + ", per_nom=" + per_nom + ", per_prenom=" + per_prenom + ", per_genre="
				+ per_genre + ", per_ddn=" + per_ddn + ", per_url=" + per_url + ", per_role=" + per_role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((per_ddn == null) ? 0 : per_ddn.hashCode());
		result = prime * result + ((per_genre == null) ? 0 : per_genre.hashCode());
		result = prime * result + ((per_id == null) ? 0 : per_id.hashCode());
		result = prime * result + ((per_nom == null) ? 0 : per_nom.hashCode());
		result = prime * result + ((per_prenom == null) ? 0 : per_prenom.hashCode());
		result = prime * result + ((per_role == null) ? 0 : per_role.hashCode());
		result = prime * result + ((per_url == null) ? 0 : per_url.hashCode());
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
		Personne other = (Personne) obj;
		if (per_ddn == null) {
			if (other.per_ddn != null)
				return false;
		} else if (!per_ddn.equals(other.per_ddn))
			return false;
		if (per_genre != other.per_genre)
			return false;
		if (per_id == null) {
			if (other.per_id != null)
				return false;
		} else if (!per_id.equals(other.per_id))
			return false;
		if (per_nom == null) {
			if (other.per_nom != null)
				return false;
		} else if (!per_nom.equals(other.per_nom))
			return false;
		if (per_prenom == null) {
			if (other.per_prenom != null)
				return false;
		} else if (!per_prenom.equals(other.per_prenom))
			return false;
		if (per_role == null) {
			if (other.per_role != null)
				return false;
		} else if (!per_role.equals(other.per_role))
			return false;
		if (per_url == null) {
			if (other.per_url != null)
				return false;
		} else if (!per_url.equals(other.per_url))
			return false;
		return true;
	}

	public Integer getPer_id() {
		return per_id;
	}

	public void setPer_id(Integer per_id) {
		this.per_id = per_id;
	}

	public String getPer_nom() {
		return per_nom;
	}

	public void setPer_nom(String per_nom) {
		this.per_nom = per_nom;
	}

	public String getPer_prenom() {
		return per_prenom;
	}

	public void setPer_prenom(String per_prenom) {
		this.per_prenom = per_prenom;
	}

	public GenrePers getPer_genre() {
		return per_genre;
	}

	public void setPer_genre(GenrePers per_genre) {
		this.per_genre = per_genre;
	}

	public LocalDate getPer_ddn() {
		return per_ddn;
	}

	public void setPer_ddn(LocalDate per_ddn) {
		this.per_ddn = per_ddn;
	}

	public String getPer_url() {
		return per_url;
	}

	public void setPer_url(String per_url) {
		this.per_url = per_url;
	}

	public String getPer_role() {
		return per_role;
	}

	public void setPer_role(String per_role) {
		this.per_role = per_role;
	}

}