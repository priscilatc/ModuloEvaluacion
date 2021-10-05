package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.DetallePreguntaCerrada;
import vistas.VW_detallepc;

public class DTDetallepc {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsDpc = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Método para llenar el resultset detalles
	public void llenarRsDpc(Connection c)
	{
		String sql = "SELECT * FROM public.detalle_preguntacerrada where estado <>3";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsDpc = ps.executeQuery();
		} 
		catch (Exception e) 
		{
			System.err.println("DT Detallepc: Error en listar Detalle Pregunta Cerrada" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ArrayList<VW_detallepc> listarDetallepc()
	{
		ArrayList<VW_detallepc> listaDetallepc = new ArrayList<VW_detallepc>();
		
		String sql = "SELECT * FROM public.vista_detallepreguntacerrada";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_detallepc vwd = new VW_detallepc();
				vwd.setIddetallepreguntacerrada(rs.getInt("iddetallepreguntacerrada"));
				vwd.setPregunta(rs.getString("pregunta"));
				vwd.setOpcion(rs.getString("opcion"));
				vwd.setNivel(rs.getString("nivel_180"));
				
				listaDetallepc.add(vwd);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DT Detallepc: Error en listar Detalle Pregunta Cerrada" + e.getMessage());
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
				System.err.println("DT Detallepc: Error en listar Detalle Pregunta Cerrada" + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return listaDetallepc;
	}
	
	public boolean guardarDetallePC(DetallePreguntaCerrada dpc) {
		boolean guardado = false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
				
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsDpc(c);
			//AQUI INICIA EL GUARDAR
			rsDpc.moveToInsertRow();
			
			rsDpc.updateString("descripcion", dpc.getDescripcion());
			rsDpc.updateInt("idpreguntacerrada", dpc.getIdPreguntaCerrada());
			rsDpc.updateInt("idnivel", dpc.getIdNivel());
			rsDpc.updateDate("fecha_creacion", sqlDate);
			rsDpc.updateInt("estado", 1);
			rsDpc.insertRow();
			rsDpc.moveToCurrentRow();
			guardado=true;
			
		} 
		catch (Exception e) 
		{
			System.err.println("DTDealleOC: Error al guardar detalle de la pregunta " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsDpc != null)
				{
					rsDpc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DTDetallePC: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	public boolean modificarDetallePC(DetallePreguntaCerrada dpc) {
		boolean modificado=false;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsDpc(c);
			rsDpc.beforeFirst();
			modificado=true;
			
			while(rsDpc.next())
			{
				if(rsDpc.getInt(1) == dpc.getIdDetallePreguntaCerrada()) 
				{
					System.out.println("Id: " + dpc.getIdDetallePreguntaCerrada());
					
					rsDpc.updateString("descripcion", dpc.getDescripcion());
					rsDpc.updateDate("fecha_edicion", sqlDate);
					rsDpc.updateInt("estado", 2);
					
					rsDpc.updateRow();
					modificado= true;
					break;
				}
			}
		}
		catch (Exception e) 
		{
			System.err.println("DTDetallePC: Error al modificar detalle " + e.getMessage());
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rsDpc != null)
				{
					rsDpc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DTDetallePC: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}		
		
		return modificado;
	}
	
	public boolean eliminarDetallePC(int iddetallepreguntacerrada) {
		boolean eliminado=true;
		Date utilDate = new Date();
		java.sql.Date sqlDate =  new java.sql.Date(utilDate.getTime());
		
		try 
		{
			c = PoolConexion.getConnection();
			this.llenarRsDpc(c);
			rsDpc.beforeFirst();
			while(rsDpc.next())
			{

				if(rsDpc.getInt(1) == iddetallepreguntacerrada) 
				{
					rsDpc.updateDate("fecha_eliminacion", sqlDate);
					rsDpc.updateInt("estado", 3);	
					rsDpc.updateRow();
					
					eliminado = true;
					break;
				}
				
			}
			
		}
		catch (SQLException e) 
		{
			System.err.println("DTDetallePC: Error al eliminar detalle " + e.getMessage());
			e.printStackTrace();
			System.err.println(e.getSQLState());
		}
		finally 
		{
			try 
			{
				if(rsDpc != null)
				{
					rsDpc.close();
				}
				if(c != null)
				{
					c.close();
				}
			} 
			catch (Exception e2) 
			{
				System.err.println("DTDetallePC: Error al cerrar conexion " + e2.getMessage());
				e2.printStackTrace();
			}
		}		
		return eliminado;
	}
	
	public ArrayList<VW_detallepc> getDetalle(int idpreguntacerrada)
	{
		ArrayList<VW_detallepc> listaDetallesPC = new ArrayList<VW_detallepc>();
		
		String sql = "SELECT * FROM public.vista_detallepreguntacerrada where idpreguntacerrada = ?";
		try 
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idpreguntacerrada);
			rs = ps.executeQuery();
			while(rs.next())
			{
				VW_detallepc vwd = new VW_detallepc();
				vwd.setIddetallepreguntacerrada(rs.getInt("iddetallepreguntacerrada"));
				vwd.setPregunta(rs.getString("pregunta"));
				vwd.setOpcion(rs.getString("opcion"));
				vwd.setNivel(rs.getString("nivel_180"));
				
				listaDetallesPC.add(vwd);
				
			}
		} 
		catch (Exception e) 
		{
			System.err.println("DT Detallepc: Error en listar Detalle Pregunta Cerrada" + e.getMessage());
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
				System.err.println("DT Detallepc: Error en listar Detalle Pregunta Cerrada" + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return listaDetallesPC;
	}
	
}
