package be.technifutur.dto;

public class Type {
	/*
	 * Field
	 */
	
	private Integer ty_id;
	private String ty_type;
	
	public Type() {
	}
	
	
	public Type(Integer ty_id, String ty_type) {
		this.ty_id = ty_id;
		this.ty_type = ty_type;
	}
	public Type(Integer ty_id) {
		this.ty_id = ty_id;
	}
	
	public Integer getTy_id() {
		return ty_id;
	}
	public void setTy_id(Integer ty_id) {
		this.ty_id = ty_id;
	}
	public String getTy_type() {
		return ty_type;
	}
	public void setTy_type(String ty_type) {
		this.ty_type = ty_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ty_id == null) ? 0 : ty_id.hashCode());
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
		Type other = (Type) obj;
		if (ty_id == null) {
			if (other.ty_id != null)
				return false;
		} else if (!ty_id.equals(other.ty_id))
			return false;
		if (ty_type == null) {
			if (other.ty_type != null)
				return false;
		} else if (!ty_type.equals(other.ty_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Type [ty_id=" + ty_id + ", ty_type=" + ty_type + "]";
	}
	
	
	

}