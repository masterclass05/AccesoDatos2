package modelo;

public class Usuario {
	private String id;
	private String nombre;
	private String apellidos;
	private String correoElectronico;
	private String numeroTelefono;
	
	
	public Usuario(String nombre, String apellidos, String correoElectronico, String numeroTelefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.numeroTelefono = numeroTelefono;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	
}
