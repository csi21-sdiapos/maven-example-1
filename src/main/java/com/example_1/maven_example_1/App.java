package com.example_1.maven_example_1;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Models.Consultas.ConsultasPostgreSQL;
import Models.DTOs.AlumnoDTO;

public class App 
{
    public static void main( String[] args )
    {
    	// Lo primero de todo será declarar un objeto de la clase Connection de java.sql. e inicializarlo como nulo (ya que esta clase no tiene un constructor vacío y no se puede dejar sólo declarado)
    	Connection conexionGenerada = null; // este objeto será el que iremos pasando como parámetro a los métodos de consultas
    
    	/************************* Hacemos un insert de un alumno *********************/
        
        ConsultasPostgreSQL.ConsultaInsertAlumnos(conexionGenerada);
        
        /****************** Obtener y mostrar la tabla alumnos de la BBDD *******************/
		
        List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();

        listaAlumnos = ConsultasPostgreSQL.ConsultaSelectAlumnos(conexionGenerada);

        System.out.println("\n\n\tID\tNombre\tApellidos\tEmail");
        System.out.println("\t-----------------------------------------------");

        for(AlumnoDTO alumno : listaAlumnos) {
        	System.out.println(alumno.toString());
        }
    }
}
