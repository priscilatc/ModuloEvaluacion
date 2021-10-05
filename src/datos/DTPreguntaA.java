package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.PreguntaAbierta;
import vistas.VW_preguntaA;

public class DTPreguntaA {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsPa = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Método para llenar el resultset pregunta abierta
	public void llenarRsPa(Connection c)
	{
		String sql = "SELECT * FROM public.pregunta_abierta where estado <>3";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPa = ps.executeQuery();
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Abierta: Error en listar Pregunta Abierta" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<VW_preguntaA> listarPreguntasa()
	{
		ArrayList<VW_preguntaA> listaPreguntasa = new ArrayList<VW_preguntaA>();
		
		String sql = "SELECT * FROM public.vista_pregunta_abierta";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_preguntaA vwp = new VW_preguntaA();
				vwp.setIdpreguntaabierta(rs.getInt("idpreguntaabierta"));
				vwp.setDescripcion(rs.getString("descripcion"));
				vwp.setNivel(rs.getString("nivel_180"));
				vwp.setPeriodo_ppp(rs.getString("periodo_ppp"));
				
				listaPreguntasa.add(vwp);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Abierta: Error en listar Pregunta Abierta" + e.getMessage());
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
				System.err.println("DT Pregunta Abierta: Error en listar Pregunta Abierta" + e2.getMessage());
				e2.printStackTrace();
			}
		}		
		return listaPreguntasa;
	}
	
	public boolean guardarPreguntaA(PreguntaAbierta pa)
	{
		boolean guardado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPa(c);
			//AQUI INICIA EL GUARDAR
			rsPa.moveToInsertRow();
			rsPa.updateString("descripcion", pa.getDescripcion());
			rsPa.updateInt("idnivel", pa.getIdNivel());
			rsPa.updateInt("idperiodoppp", pa.getIdPeriodoPPP());
			rsPa.updateDate("fecha_creacion", sqlDate);
			rsPa.updateInt("estado", 1);
			
			rsPa.insertRow();
			rsPa.moveToCurrentRow();
			guardado = true;
			//FIN DEL GUARDAR
			
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Abierta: Error al guardar pregunta abierta " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPa != null)
				{
					rsPa.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Abierta: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	public boolean modificarPreguntaA(PreguntaAbierta pa)
	{
		boolean modificado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPa(c);
			rsPa.beforeFirst();
			modificado = true;
			
				
			while(rsPa.next())
			{
				if(rsPa.getInt(1) == pa.getIdPreguntaAbierta()) 
				{
					System.out.println("Id de la pregunta: " + pa.getIdPreguntaAbierta());
					
					rsPa.updateString("descripcion", pa.getDescripcion());
					rsPa.updateInt("idnivel", pa.getIdNivel());
					rsPa.updateInt("idperiodoppp", pa.getIdPeriodoPPP());
					rsPa.updateDate("fecha_edicion", sqlDate);
					rsPa.updateInt("estado", 2);
					
					rsPa.updateRow();
					modificado = true;
					break;
				}
				
			}
			
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Abierta: Error al modificar pregunta abierta" + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPa != null)
				{
					rsPa.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Abierta: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return modificado;
	}
	
	public boolean eliminarPreguntaA(int idpreguntaabierta)
	{
		boolean eliminado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPa(c);
			rsPa.beforeFirst();
			while(rsPa.next())
			{
				
				if(rsPa.getInt(1) == idpreguntaabierta)
					rsPa.updateInt("estado", 3);	
					rsPa.updateDate("fecha_eliminacion", sqlDate);
					rsPa.updateRow();
					
					eliminado = true;
					break;
				}
				
			}
			 
		catch (SQLException e) 
		{
			System.err.println("DT Pregunta Abierta: Error al eliminar pregunta abierta " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getSQLState());
		}
		finally 
		{
			try 
			{
				if(rsPa != null)
				{
					rsPa.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Abierta: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return eliminado;
	}
	
	public PreguntaAbierta getPreguntaA(int idpreguntaabierta)
	{
		PreguntaAbierta pa = new PreguntaAbierta();
		String sql = "Select * from public.pregunta_abierta where estado <> 3 and idpreguntaabierta = ?";
		
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idpreguntaabierta);
			rs = ps.executeQuery();
			if(rs.next())
			{
				pa.setIdPreguntaAbierta(idpreguntaabierta);
				pa.setDescripcion(rs.getString("descripcion"));
				pa.setIdNivel(rs.getInt("idnivel"));
				pa.setIdPeriodoPPP(rs.getInt("idperiodoppp"));
			}
		} 
		catch (SQLException e) 
		{
			System.err.println("DATOS: error getPreguntaA(): " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPa != null)
				{
					rsPa.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Abierta: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		
		return pa;
	}
}
