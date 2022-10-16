package Models.Consultas;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Conexiones.ConexionPostgreSQL;
import Models.DTOs.AlumnoDTO;
import Models.ToDTOs.PostgreSQLtoDTO;
import Util.VariablesConexionPostgreSQL;

public class ConsultasPostgreSQL {

	/**************************************** CONSULTAS SELECT *********************************************/
	
    public static List<AlumnoDTO> ConsultaSelectAlumnos(Connection conexionGenerada)
    {
        List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
        
        // Declaramos el Statement(declaraciónSQL) y el ResultSet(resultadoSQL) y los inicializamos como null
        Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		
		// También declaramos un objeto de nuestra clase ConexionPostgreSQL y lo inicializamos con su constructor vacío
		ConexionPostgreSQL conexionPostgresql = new ConexionPostgreSQL();
		
		// creamos la conexión a nuestra BBDD con el objeto de la clase Connection, y utilizando el método de generaConexion() de nuestra clase ConexionPostgreSQL, el cual nos pedirá los parámetros de conexión...
		conexionGenerada = conexionPostgresql.generaConexion(VariablesConexionPostgreSQL.getHost(),VariablesConexionPostgreSQL.getPort(),VariablesConexionPostgreSQL.getDb(),VariablesConexionPostgreSQL.getUser(),VariablesConexionPostgreSQL.getPass());
		
		System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Realiza consulta a PostgreSQL");
		
		if(conexionGenerada != null) {
			
			try {
				// Definimos la consulta y la ejecutamos
				declaracionSQL = conexionGenerada.createStatement();
				resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"EjemploInicial\".\"alumnos\"");
				
				// Recogemos en una lista los datos resultantes de llamar a nuestra consulta 
				listaAlumnos = PostgreSQLtoDTO.ConsultaSelectAlumnosToDTO(resultadoConsulta);

				// Cerramos el resultado y la declaración de la consulta
				System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Cierre del resultado, de la declaración, y de la conexión");
			    resultadoConsulta.close();
			    declaracionSQL.close();
			    // Cerramos la conexión con la BBDD
			    conexionGenerada.close();
				
			} catch (SQLException e) {
				System.out.println("\n[ERROR-Consultas-ConsultasPostgreSQL.java] Error generando la declaracionSQL: " + e);
			}
		}
		
		return listaAlumnos;
    }
    
    /*************************************** CONSULTAS INSERTS ******************************************/
    
    public static void ConsultaInsertAlumnos(Connection conexionGenerada)
    {
        Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ConexionPostgreSQL conexionPostgresql = new ConexionPostgreSQL();
		
		conexionGenerada = conexionPostgresql.generaConexion(VariablesConexionPostgreSQL.getHost(),VariablesConexionPostgreSQL.getPort(),VariablesConexionPostgreSQL.getDb(),VariablesConexionPostgreSQL.getUser(),VariablesConexionPostgreSQL.getPass());
		
		System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Realiza consulta a PostgreSQL");
		
		if(conexionGenerada != null) {
			
			try {
				declaracionSQL = conexionGenerada.createStatement();
				resultadoConsulta = declaracionSQL.executeQuery("INSERT INTO \"EjemploInicial\".\"alumnos\" (alumno_id, alumno_nombre, alumno_apellidos, alumno_email) VALUES (DEFAULT, 'ivan', 'iglesias', 'ivan@gmail.com')");

				System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Cierre del resultado, de la declaración, y de la conexión");
				
			    resultadoConsulta.close();
			    declaracionSQL.close();
			    conexionGenerada.close();
				
			} catch (SQLException e) {
				System.out.println("\n[ERROR-Consultas-ConsultasPostgreSQL.java] Error generando la declaracionSQL: " + e);
			}
		}
		
    }
}
