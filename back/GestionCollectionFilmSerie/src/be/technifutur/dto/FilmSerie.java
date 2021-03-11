package be.technifutur.dto;

import java.time.LocalDateTime;

public class FilmSerie {
	/*
	 * FIELD
	 */
	private Integer fs_id;
	private String fs_nom;
	private String fs_synopsis;
	private Type ty_type;
	private LocalDateTime fs_date_sortie;
	private Genre ge_genre;
	private Integer fs_saison;
	private Integer fs_episode;
	private LocalDateTime fs_date_creation;
	private LocalDateTime fs_date_modif;
	private String fs_img;

	/*
	 * CONSTRUCTOR
	 */
	public FilmSerie() {
	}

	// constructeur film
	public FilmSerie(Integer fs_id, String fs_nom, String fs_synopsis, Type ty_type, LocalDateTime fs_date_sortie,
			Genre ge_genre,String fs_img) {
		this.fs_id = fs_id;
		this.fs_nom = fs_nom;
		this.fs_synopsis = fs_synopsis;
		this.ty_type = ty_type;
		this.fs_date_sortie = fs_date_sortie;
		this.ge_genre = ge_genre;
		this.fs_img = fs_img;
	}

	// constructeur serie
	public FilmSerie(Integer fs_id, String fs_nom, String fs_synopsis, Type ty_type, LocalDateTime fs_date_sortie,
			Genre ge_genre, Integer fs_saison, Integer fs_episode,String fs_img) {
		this.fs_id = fs_id;
		this.fs_nom = fs_nom;
		this.fs_synopsis = fs_synopsis;
		this.ty_type = ty_type;
		this.fs_date_sortie = fs_date_sortie;
		this.ge_genre = ge_genre;
		this.fs_saison = fs_saison;
		this.fs_episode = fs_episode;
		this.fs_img = fs_img;
	}

	// sans id, sans date creation et date modif
	public FilmSerie(String fs_nom, String fs_synopsis, Type ty_type, LocalDateTime fs_date_sortie, Genre ge_genre,
			Integer fs_saison, Integer fs_episode) {
		this.fs_nom = fs_nom;
		this.fs_synopsis = fs_synopsis;
		this.ty_type = ty_type;
		this.fs_date_sortie = fs_date_sortie;
		this.ge_genre = ge_genre;
		this.fs_saison = fs_saison;
		this.fs_episode = fs_episode;
		this.fs_date_creation = fs_date_creation;
		this.fs_date_modif = fs_date_modif;
	}

	// Constructeur full
	public FilmSerie(Integer fs_id, String fs_nom, String fs_synopsis, Type ty_type, LocalDateTime fs_date_sortie,
			Genre ge_genre, Integer fs_saison, Integer fs_episode, LocalDateTime fs_date_creation,
			LocalDateTime fs_date_modif) {
		this.fs_id = fs_id;
		this.fs_nom = fs_nom;
		this.fs_synopsis = fs_synopsis;
		this.ty_type = ty_type;
		this.fs_date_sortie = fs_date_sortie;
		this.ge_genre = ge_genre;
		this.fs_saison = fs_saison;
		this.fs_episode = fs_episode;
		this.fs_date_creation = fs_date_creation;
		this.fs_date_modif = fs_date_modif;
	}

	/*
	 * GETTER / SETTER
	 */

	public Integer getFs_id() {
		return fs_id;
	}

	public void setFs_id(Integer fs_id) {
		this.fs_id = fs_id;
	}

	public String getFs_nom() {
		return fs_nom;
	}

	public void setFs_nom(String fs_nom) {
		this.fs_nom = fs_nom;
	}

	public String getFs_synopsis() {
		return fs_synopsis;
	}

	public void setFs_synopsis(String fs_synopsis) {
		this.fs_synopsis = fs_synopsis;
	}

	public Type getTy_type() {
		return ty_type;
	}

	public void setTy_type(Type ty_type) {
		this.ty_type = ty_type;
	}

	public LocalDateTime getFs_date_sortie() {
		return fs_date_sortie;
	}

	public void setFs_date_sortie(LocalDateTime fs_date_sortie) {
		this.fs_date_sortie = fs_date_sortie;
	}

	public Genre getGe_genre() {
		return ge_genre;
	}

	public void setGe_genre(Genre ge_genre) {
		this.ge_genre = ge_genre;
	}

	public Integer getFs_saison() {
		return fs_saison;
	}

	public void setFs_saison(Integer fs_saison) {
		this.fs_saison = fs_saison;
	}

	public Integer getFs_episode() {
		return fs_episode;
	}

	public void setFs_episode(Integer fs_episode) {
		this.fs_episode = fs_episode;
	}

	public LocalDateTime getFs_date_creation() {
		return fs_date_creation;
	}

	public void setFs_date_creation(LocalDateTime fs_date_creation) {
		this.fs_date_creation = fs_date_creation;
	}

	public LocalDateTime getFs_date_modif() {
		return fs_date_modif;
	}

	public void setFs_date_modif(LocalDateTime fs_date_modif) {
		this.fs_date_modif = fs_date_modif;
	}
	
	public String getFs_img() {
		return fs_img;
	}

	public void setFs_img(String fs_img) {
		this.fs_img = fs_img;
	}
	

	/*
	 * METHOD
	 */	

	@Override
	public String toString() {
		return "FilmSerie [fs_id=" + fs_id + ", fs_nom=" + fs_nom + ", fs_synopsis=" + fs_synopsis + ", ty_type="
				+ ty_type + ", fs_date_sortie=" + fs_date_sortie + ", ge_genre=" + ge_genre + ", fs_saison=" + fs_saison
				+ ", fs_episode=" + fs_episode + ", fs_date_creation=" + fs_date_creation + ", fs_date_modif="
				+ fs_date_modif + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fs_date_creation == null) ? 0 : fs_date_creation.hashCode());
		result = prime * result + ((fs_date_modif == null) ? 0 : fs_date_modif.hashCode());
		result = prime * result + ((fs_date_sortie == null) ? 0 : fs_date_sortie.hashCode());
		result = prime * result + ((fs_episode == null) ? 0 : fs_episode.hashCode());
		result = prime * result + ((fs_id == null) ? 0 : fs_id.hashCode());
		result = prime * result + ((fs_img == null) ? 0 : fs_img.hashCode());
		result = prime * result + ((fs_nom == null) ? 0 : fs_nom.hashCode());
		result = prime * result + ((fs_saison == null) ? 0 : fs_saison.hashCode());
		result = prime * result + ((fs_synopsis == null) ? 0 : fs_synopsis.hashCode());
		result = prime * result + ((ge_genre == null) ? 0 : ge_genre.hashCode());
		result = prime * result + ((ty_type == null) ? 0 : ty_type.hashCode());
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
		FilmSerie other = (FilmSerie) obj;
		if (fs_date_creation == null) {
			if (other.fs_date_creation != null)
				return false;
		} else if (!fs_date_creation.equals(other.fs_date_creation))
			return false;
		if (fs_date_modif == null) {
			if (other.fs_date_modif != null)
				return false;
		} else if (!fs_date_modif.equals(other.fs_date_modif))
			return false;
		if (fs_date_sortie == null) {
			if (other.fs_date_sortie != null)
				return false;
		} else if (!fs_date_sortie.equals(other.fs_date_sortie))
			return false;
		if (fs_episode == null) {
			if (other.fs_episode != null)
				return false;
		} else if (!fs_episode.equals(other.fs_episode))
			return false;
		if (fs_id == null) {
			if (other.fs_id != null)
				return false;
		} else if (!fs_id.equals(other.fs_id))
			return false;
		if (fs_img == null) {
			if (other.fs_img != null)
				return false;
		} else if (!fs_img.equals(other.fs_img))
			return false;
		if (fs_nom == null) {
			if (other.fs_nom != null)
				return false;
		} else if (!fs_nom.equals(other.fs_nom))
			return false;
		if (fs_saison == null) {
			if (other.fs_saison != null)
				return false;
		} else if (!fs_saison.equals(other.fs_saison))
			return false;
		if (fs_synopsis == null) {
			if (other.fs_synopsis != null)
				return false;
		} else if (!fs_synopsis.equals(other.fs_synopsis))
			return false;
		if (ge_genre == null) {
			if (other.ge_genre != null)
				return false;
		} else if (!ge_genre.equals(other.ge_genre))
			return false;
		if (ty_type == null) {
			if (other.ty_type != null)
				return false;
		} else if (!ty_type.equals(other.ty_type))
			return false;
		return true;
	}

}
