package entidades;

import java.sql.Date;

public class PreguntaAbierta {
	
	private int idPreguntaAbierta;
	private String descripcion;
	private int idNivel;
	private int idPeriodoPPP;
	private Date fecha_creacion;
	private Date fecha_edicion;
	private Date fecha_eliminacion;
	private int estado;
	
	public int getIdPreguntaAbierta() {
		return idPreguntaAbierta;
	}
	public void setIdPreguntaAbierta(int idPreguntaAbierta) {
		this.idPreguntaAbierta = idPreguntaAbierta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdPeriodoPPP() {
		return idPeriodoPPP;
	}
	public void setIdPeriodoPPP(int idPeriodoPPP) {
		this.idPeriodoPPP = idPeriodoPPP;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Date getFecha_edicion() {
		return fecha_edicion;
	}
	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	public Date getFecha_eliminacion() {
		return fecha_eliminacion;
	}
	public void setFecha_eliminacion(Date fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
	}

}
