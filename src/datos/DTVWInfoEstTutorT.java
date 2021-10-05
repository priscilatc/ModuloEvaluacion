package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vistas.VW_info_Est_tutortecnico;

public class DTVWInfoEstTutorT {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsVI = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llenarRsVI(Connection c)
	{
		String sql = "SELECT * FROM public.vista_info_Est_tutortecnico where estado <>3";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsVI = ps.executeQuery();
		} 
		catch (Exception e) 
		{
			System.err.println("DTVW Info Estudiante-Tutor Tecnico: Error en listar Asignacion " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<VW_info_Est_tutortecnico> listarTutorTInfo(int idestudiante)
	{
		ArrayList<VW_info_Est_tutortecnico> listaTutorTInfo = new ArrayList<VW_info_Est_tutortecnico>();
		
		String sql = "SELECT * FROM public.vista_info_Est_tutortecnico where idestudiante = ?";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_info_Est_tutortecnico vwi = new VW_info_Est_tutortecnico();
				vwi.setNombre(rs.getString("nombre"));
				vwi.setCargo(rs.getString("cargo"));		
				vwi.setOrganizacion(rs.getString("organizacion"));
				vwi.setTrato(rs.getString("trato"));
				vwi.setCelular(rs.getString("celular"));
				vwi.setDireccion(rs.getString("direccion"));
				vwi.setCorreo(rs.getString("correo"));
				listaTutorTInfo.add(vwi);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DTVW Info esttutortecnico: Error en listar tutor" + e.getMessage());
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
				System.err.println("DT Asignacion: Error en listar Asignacion" + e2.getMessage());
				e2.printStackTrace();
			}
		}	
		return listaTutorTInfo;
	}
}
