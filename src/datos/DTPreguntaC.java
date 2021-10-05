package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.PreguntaCerrada;
import vistas.VW_preguntacerrada;

public class DTPreguntaC {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsPc = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Método para llenar el resultset pregunta cerrada
	public void llenarRsPc(Connection c)
	{
		String sql = "SELECT * FROM public.pregunta_cerrada where estado <>3";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsPc = ps.executeQuery();
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Cerrada: Error en listar Pregunta Cerrada" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<VW_preguntacerrada> listarPreguntasc()
	{
		ArrayList<VW_preguntacerrada> listaPreguntasc = new ArrayList<VW_preguntacerrada>();
		
		String sql = "SELECT * FROM public.vista_preguntacerrada";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_preguntacerrada vwp = new VW_preguntacerrada();
				vwp.setIdpreguntacerrada(rs.getInt("idpreguntacerrada"));
				vwp.setDescripcion(rs.getString("descripcion"));
				vwp.setPeriodo_ppp(rs.getString("periodo_ppp"));
				
				listaPreguntasc.add(vwp);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Cerrada: Error en listar Pregunta Cerrada" + e.getMessage());
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
				System.err.println("DT Pregunta Cerrada: Error en listar Pregunta Cerrada" + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return listaPreguntasc;
	}
	public boolean guardarPreguntaC(PreguntaCerrada pc)
	{
		boolean guardado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPc(c);
			//AQUI INICIA EL GUARDAR
			rsPc.moveToInsertRow();
			rsPc.updateString("descripcion", pc.getDescripcion());
			rsPc.updateInt("idperiodoppp", pc.getIdPeriodoPPP());
			rsPc.updateDate("fecha_creacion", sqlDate);
			rsPc.updateInt("estado", 1);
			
			rsPc.insertRow();
			rsPc.moveToCurrentRow();
			guardado = true;
			//FIN DEL GUARDAR
			
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Cerrada: Error al guardar pregunta cerrada " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPc != null)
				{
					rsPc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Cerrada: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	public boolean modificarPreguntaC(PreguntaCerrada pc)
	{
		boolean modificado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPc(c);
			rsPc.beforeFirst();
			modificado = true;
			
				
			while(rsPc.next())
			{
				if(rsPc.getInt(1) == pc.getIdPreguntaCerrada()) 
				{
					System.out.println("Id de la pregunta: " + pc.getIdPreguntaCerrada());
					
					rsPc.updateString("descripcion", pc.getDescripcion());
					rsPc.updateInt("idperiodoppp", pc.getIdPeriodoPPP());
					rsPc.updateDate("fecha_edicion", sqlDate);
					rsPc.updateInt("estado", 2);
					
					rsPc.updateRow();
					modificado = true;
					break;
				}
				
			}
			
		} 
		catch (Exception e) 
		{
			System.err.println("DT Pregunta Cerrada: Error al modificar pregunta cerrada" + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPc != null)
				{
					rsPc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Cerrada: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return modificado;
	}
	
	public boolean eliminarPreguntaC(int idpreguntacerrada)
	{
		boolean eliminado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsPc(c);
			rsPc.beforeFirst();
			while(rsPc.next())
			{
				
				if(rsPc.getInt(1) == idpreguntacerrada)
					rsPc.updateInt("estado", 3);	
					rsPc.updateDate("fecha_eliminacion", sqlDate);
					rsPc.updateRow();
					
					eliminado = true;
					break;
				}
				
			}
			 
		catch (SQLException e) 
		{
			System.err.println("DT Pregunta Cerrada: Error al eliminar pregunta cerrada " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getSQLState());
		}
		finally 
		{
			try 
			{
				if(rsPc != null)
				{
					rsPc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Cerrada: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return eliminado;
	}
	
	public PreguntaCerrada getPreguntaC(int idpreguntacerrada)
	{
		PreguntaCerrada pc = new PreguntaCerrada();
		String sql = "Select * from public.pregunta_cerrada where estado <> 3 and idpreguntacerrada = ?";
		
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idpreguntacerrada);
			rs = ps.executeQuery();
			if(rs.next())
			{
				pc.setIdPreguntaCerrada(idpreguntacerrada);
				pc.setDescripcion(rs.getString("descripcion"));
				pc.setIdPeriodoPPP(rs.getInt("idperiodoppp"));
			}
		} 
		catch (SQLException e) 
		{
			System.err.println("DATOS: error getPreguntaC(): " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsPc != null)
				{
					rsPc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DT Pregunta Cerrada: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}				
		return pc;
	}
}
