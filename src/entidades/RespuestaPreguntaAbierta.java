package entidades;

public class RespuestaPreguntaAbierta {

	private int idRespuestaPreguntaAbierta;
	private String descripcion;
	private int idPreguntaAbierta;
	private int idEvaluacion;
	private int estado;
	
	public int getIdRespuestaPreguntaAbierta() {
		return idRespuestaPreguntaAbierta;
	}
	public void setIdRespuestaPreguntaAbierta(int idRespuestaPreguntaAbierta) {
		this.idRespuestaPreguntaAbierta = idRespuestaPreguntaAbierta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdPreguntaAbierta() {
		return idPreguntaAbierta;
	}
	public void setIdPreguntaAbierta(int idPreguntaAbierta) {
		this.idPreguntaAbierta = idPreguntaAbierta;
	}
	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
