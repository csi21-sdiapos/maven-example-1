package Models.ToDTOs;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.DTOs.AlumnoDTO;

public class PostgreSQLtoDTO {

	public static List<AlumnoDTO> ConsultaSelectAlumnosToDTO(ResultSet resultadoConsulta)
    {
        List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		
        try {
        	while ( resultadoConsulta.next() ) {
    			listaAlumnos.add
    				(
    					new AlumnoDTO
    						(
    								resultadoConsulta.getInt("alumno_id"),
    								resultadoConsulta.getString("alumno_nombre"),
    						        resultadoConsulta.getString("alumno_apellidos"),
    						        resultadoConsulta.getString("alumno_email")
    						)					
    				);
    	    }

        } catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERROR-conexionPostgresql-main] Error generando la declaracionSQL: " + e);
		}
        
        return listaAlumnos;
    }
}
