package vistas;

import java.sql.Date;

public class VW_evaluacion {
	private int idevaluacion;
	private Date fecha_evaluacion;
	private String nivel;
	private String estudiante;
	private String tutor;
	private String periodo_ppp;
	
	public int getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	public Date getFecha_evaluacion() {
		return fecha_evaluacion;
	}
	public void setFecha_evaluacion(Date fecha_evaluacion) {
		this.fecha_evaluacion = fecha_evaluacion;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public String getPeriodo_ppp() {
		return periodo_ppp;
	}
	public void setPeriodo_ppp(String periodo_ppp) {
		this.periodo_ppp = periodo_ppp;
	}
}
