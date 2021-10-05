package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vistas.VW_evaluacion;

public class DTEvaluacion {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsE = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Método para llenar el resultset evaluacion
	public void llenarRsEvaluacion(Connection c)
	{
		String sql = "SELECT * FROM public.evaluacion where estado <>3";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsE = ps.executeQuery();
		} 
		catch (Exception e) 
		{
			System.err.println("DT Evaluacion: Error en listar evaluaciones " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<VW_evaluacion> listarEvaluaciones()
	{
		ArrayList<VW_evaluacion> listaEvaluaciones = new ArrayList<VW_evaluacion>();
		
		String sql = "SELECT * FROM public.vista_evaluacion";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_evaluacion vwe = new VW_evaluacion();
				vwe.setIdevaluacion(rs.getInt("idevaluacion"));
				vwe.setFecha_evaluacion(rs.getDate("fecha_evaluacion"));
				vwe.setNivel(rs.getString("nivel"));
				vwe.setEstudiante(rs.getString("estudiante"));
				vwe.setTutor(rs.getString("tutor"));
				vwe.setPeriodo_ppp(rs.getString("periodo_ppp"));
				
				listaEvaluaciones.add(vwe);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DT Evaluacion: Error en listar evaluaciones " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs != null)
					rs.close();
				
				if(ps != null)
					ps.close();
				
				if(c != null)
					PoolConexion.cerrarConexion(c);
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Evaluacion: Error en listar evaluaciones" + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return listaEvaluaciones;
	}
}
