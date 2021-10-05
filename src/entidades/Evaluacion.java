package entidades;

import java.sql.Date;

public class Evaluacion {

	private int idEvaluacion;
	private Date fechaEvaluacion;
	private int idNivel;
	private String idEstudiante;
	private String idTutorTecnico;
	private int idPeriodoPPP;
	private int estado;
	
	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	public int getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}
	public String getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getIdTutorTecnico() {
		return idTutorTecnico;
	}
	public void setIdTutorTecnico(String idTutorTecnico) {
		this.idTutorTecnico = idTutorTecnico;
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
	
}
