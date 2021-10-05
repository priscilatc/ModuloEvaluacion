package vistas;

public class VW_usuario_rol {
	private int id_usuario_rol;
	private int idusuario;
	private String usuario;
	private String pwd;
	private int estado;
	private int idrol;
	private String descripcion;
	
	public int getId_usuario_rol() {
		return id_usuario_rol;
	}
	public void setId_usuario_rol(int id_usuario_rol) {
		this.id_usuario_rol = id_usuario_rol;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
