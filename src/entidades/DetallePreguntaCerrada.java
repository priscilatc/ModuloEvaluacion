package entidades;

import java.sql.Date;

public class DetallePreguntaCerrada {

	private int idDetallePreguntaCerrada;
	private String descripcion;
	private int idPreguntaCerrada;
	private int idNivel;
	private Date fecha_creacion;
	private Date fecha_edicion;
	private Date fecha_eliminacion;
	private int estado;
	
	public int getIdDetallePreguntaCerrada() {
		return idDetallePreguntaCerrada;
	}
	public void setIdDetallePreguntaCerrada(int idDetallePreguntaCerrada) {
		this.idDetallePreguntaCerrada = idDetallePreguntaCerrada;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdPreguntaCerrada() {
		return idPreguntaCerrada;
	}
	public void setIdPreguntaCerrada(int idPreguntaCerrada) {
		this.idPreguntaCerrada = idPreguntaCerrada;
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
