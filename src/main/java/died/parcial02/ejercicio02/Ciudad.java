package died.parcial02.ejercicio02;

public class Ciudad {
	
	public Integer habitantes;
	public String nombre;
	
	public Ciudad() {}
	public Ciudad(String nombre,Integer habitantes) {
		super();
		this.habitantes = habitantes;
		this.nombre = nombre;
	}
	public Integer getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "habitantes=" + habitantes + "; nombre=" + nombre + ",";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	

}
