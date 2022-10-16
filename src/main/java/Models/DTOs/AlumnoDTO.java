package Models.DTOs;

public class AlumnoDTO {

	// ATRIBUTOS
		public int alumno_id;
		public String alumno_nombre;
		public String alumno_apellidos;
		public String alumno_email;
		
		
		// CONSTRUCTORES
		public AlumnoDTO(int alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_email) {
			super();
			this.alumno_id = alumno_id;
			this.alumno_nombre = alumno_nombre;
			this.alumno_apellidos = alumno_apellidos;
			this.alumno_email = alumno_email;
		}
		

		// GETTERS Y SETTERS
		public int getAlumno_id() {
			return alumno_id;
		}
		public void setAlumno_id(int alumno_id) {
			this.alumno_id = alumno_id;
		}
		public String getAlumno_nombre() {
			return alumno_nombre;
		}
		public void setAlumno_nombre(String alumno_nombre) {
			this.alumno_nombre = alumno_nombre;
		}
		public String getAlumno_apellidos() {
			return alumno_apellidos;
		}
		public void setAlumno_apellidos(String alumno_apellidos) {
			this.alumno_apellidos = alumno_apellidos;
		}
		public String getAlumno_email() {
			return alumno_email;
		}
		public void setAlumno_email(String alumno_email) {
			this.alumno_email = alumno_email;
		}
		
		
		// MÉTODOS
		
		
		// ToString
	    @Override
	    public String toString() {
	    	return 
	    		"\t" + alumno_id + 
	    		"\t" + alumno_nombre +
	    		"\t" + alumno_apellidos +
	    		"\t" + alumno_email;
	    }
}
