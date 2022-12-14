# Maven Example 1

<!-- TOC -->

- [0. ¿Qué es Maven?](#%C2%BFqu%C3%A9-es-maven)
- [1. Crear el proyecto](#crear-el-proyecto)
- [2. Update Project](#update-project)
- [3. Ejecución del proyecto](#ejecuci%C3%B3n-del-proyecto)
- [4. pom.xml --> Dependencias](#pomxml----dependencias)
- [5. Ejemplo Maven MVC por consola](#ejemplo-maven-mvc-por-consola)
- [6. Conclusión final](#conclusi%C3%B3n-final)
- [7. Extra: Consultas UPDATE y DELETE](#extra-consultas-update-y-delete)
    - [Consulta Update](#consulta-update)
        - [*Models --> Consultas --> ConsultasPostgreSQL.java*](#models----consultas----consultaspostgresqljava)
        - [*Default Package --> App.java*](#default-package----appjava)
    - [Consulta DELETE](#consulta-delete)
        - [*Models --> Consultas --> ConsultasPostgreSQL.java*](#models----consultas----consultaspostgresqljava)
        - [*Default Package --> App.java*](#default-package----appjava)

<!-- /TOC -->

# 0. ¿Qué es Maven?

Maven es una herramienta para la gestión de proyectos, que nos permitirá administrar completamente el ciclo de vida de la misma. Comúnmente se conoce a Maven como un gestor de dependencias Y YA. Y eso no es del todo cierto. Podemos considerarlo como una herramienta de construcción con muchas características, que nos ayuda a gestionar las dependencias, test, documentación, compilaciones, distribuciones e incluso los mailing list.

¿Qué es lo que Maven puede hacer por nosotros? En muy resumidas cuentas, lo siguiente:

- Build. Construye nuestro código fuente del proyecto

- Test. Ejecuta los casos de prueba
- Gestiona las dependencias de nuestro proyecto. Es cierto que no es sólo un gestor, pero para mi es de lo mejor que tiene Maven. Importa las librerías automáticamente desde un repositorio remoto. Nos podemos olvidar de hacer esa tarea manualmente.

- Permite la creación y descarga de plantillas de proyectos para tener la estructura ya creada. Por ejemplo si nos vamos a dedicar a hacer páginas web, o conectores, nos interesará para ahorrarnos el trabajo de tener que empezar desde cero una y otra vez

- Crea una web con la documentación del proyecto

- Desplega el proyecto (AKA artefacto) en servidor

- Y por supuesto, perfecta integración con Git, SVN, Jira...

Conceptos de vocabulario:

- artefacto. Es un proyecto que lo gestiona Maven y que incluye un fichero llamado pom.xml.

- POM. Son las siglas de Project Object Model. Es un fichero XML que contiene la configuración del artefacto. Más adelante trabajaremos con él. Si has programado en Android anteriormente, un símil adecuado sería el AndroidManifest.

- groupId. El identificador único para crear nuestro artefacto. Se suele poner el mismo que en un paquete java. com.programandoapasitos

# 1. Crear el proyecto

![](./img/1.png)

![](./img/2.png)

![](./img/3.png)

![](./img/4.png)

![](./img/5.png)

# 2. Update Project

**Nota**: Ya hemos añadido antes nuestro JDK19 al *build path*, así que no tenemos que tocar el *pom.xml* para que Maven reconozca nuestro java... porque en el pom ya viene el plugin de 
```xml
<artifactId>maven-compiler-plugin</artifactId>
```

![](./img/6.png)

![](./img/7.png)

# 3. Ejecución del proyecto

La opción de *Run as ...* se nos subdivide en las siguientes opciones:

- Maven build → Compila el código del proyecto

- Maven clean → Elimina todos los ficheros hechos por los builds anteriores

- Maven generate-sources → Genera código para incluirlo en la compilación

- Maven install → Instala los paquetes de la biblioteca en un repositorio local, compila el proyecto y lo comprueba.

![](./img/8.png)

![](./img/9.png)

# 4. pom.xml --> Dependencias

![](./img/10.png)

Para gestionar las dependencias, dentro del POM deberemos fijarnos en el tag dependencies.
Por defecto tenemos cargada la librería de junit, que nos servirá para ver un ejemplo de cómo añadir más librerías.

Tenemos, al igual que con los plugin, los tag de groupId y artifactId. Aparte de eso, lo que nos interesa también es el tercer tag, version, que nos permitirá indicar la versión de la librería y, en caso de tener que modificarla, bastará con cambiar ese valor y volver a hacer un install.

¿de dónde podemos conseguir las dependencias?

Hay varios sitios y Google lo sabe todo, pero así más concretamente hay una página web llamada MVN Repository (https://mvnrepository.com/) que cuenta con un amplio abanico de dependencias organizadas por temas que es de lo mejorcito que podemos encontrar.

Simplemente entraremos en la dependencia que nos interese, por ejemplo el conector JDBC de MySQL, elegiremos la versión que queramos cargar en nuestro proyecto y en la parte inferior de la página nos aparecerá el código XML de Maven que deberemos copiar en el POM.

![](./img/11.png)

![](./img/12.png)

![](./img/13.png)

![](./img/14.png)

Y después de hacer un Maven install ya estaremos en disposición de usar nuestra nueva dependencia del driver de PostgreSQL.

![](./img/15.png)

# 5. Ejemplo Maven MVC por consola

Para ver si la dependencia del driver de PostgreSQL funciona correctamente, se me ha ocurrido replicar en este artefacto, la última práctica que hicimos en clase, la cual realizaba una consulta insert y después un select para mostrar el resultado por consola.

Como ya he desarrollado esa práctica en repositorios anteriores, no entraré en detalle otra vez aquí, si no que volveré a crear los paquetes y las clases y le daré al botón del *play* (run as java application)... y funciona todo perfectamente!

![](./img/16.png)

![](./img/17.png)

# 6. Conclusión final

Durante esta práctica, aparte de conocer por encima mediante un vistazo general qué es Maven, en esta parte en concreto hemos practicado con las dependencias... y para entenderlo rápidamente se me ha ocurrido la siguiente analogía: Maven y su archivo *pom.xml*, serían en sus equivalentes más modernos, lo que ya conocemos como NPM (de node) y su *package.json*, es decir, por un lado tenemos un archivo donde definimos nuestras dependencias y sus versiones, y por otro lado tenemos un gestor de dependencias que con un comando, nos instala todas las dependencias que hay definidas. 

De este modo, una persona que se descarga el proyecto para seguir el trabajo de un compañero de su empresa, pues con solo un comando se instala todo lo necesario para que el proyecto funcione y poder seguir trabajando con él, amortiguando así en mayor medida los posibles fallos humanos que derivarían de tener que instalar (añadir el *.jar* al *build path*) uno mismo todas las dependencias requeridas.

# Extra: Consultas UPDATE y DELETE

**Nota**: aún estamos haciendo pruebas en consola (sin vistas).

## Consulta Update

### *Models --> Consultas --> ConsultasPostgreSQL.java*

```java
public static void ConsultaUpdateAlumnos(Connection conexionGenerada)
    {
        Statement declaracionSQL = null;
        ResultSet resultadoConsulta = null;
        ConexionPostgreSQL conexionPostgresql = new ConexionPostgreSQL();
        
        conexionGenerada = conexionPostgresql.generaConexion(VariablesConexionPostgreSQL.getHost(),VariablesConexionPostgreSQL.getPort(),VariablesConexionPostgreSQL.getDb(),VariablesConexionPostgreSQL.getUser(),VariablesConexionPostgreSQL.getPass());
        
        System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Realiza consulta a PostgreSQL");
        
        // pedimos un id por consola
        System.out.print("\n\tIntroduzca un alumno_id:\t");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        
        if(conexionGenerada != null) {
            
            try {
                declaracionSQL = conexionGenerada.createStatement();
                resultadoConsulta = declaracionSQL.executeQuery("UPDATE \"EjemploInicial\".\"alumnos\" SET alumno_nombre = 'updateName', alumno_apellidos = 'updateSurname' WHERE alumno_id = '"+id+"'");

                System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Cierre del resultado, de la declaración, y de la conexión");
                
                resultadoConsulta.close();
                declaracionSQL.close();
                conexionGenerada.close();
                sc.close();
                
            } catch (SQLException e) {
                System.out.println("\n[ERROR-Consultas-ConsultasPostgreSQL.java] Error generando la declaracionSQL: " + e);
            }
        }
    }
```

### *(Default Package) --> App.java*

```java
/********************** Hacemos un update del (primer) alumno con id=1 *************/
        
ConsultasPostgreSQL.ConsultaUpdateAlumnos(conexionGenerada);
        
/*********** Volvemos a obtener y mostrar la tabla alumnos de la BBDD ************/
        
listaAlumnos = new ArrayList<AlumnoDTO>();

listaAlumnos = ConsultasPostgreSQL.ConsultaSelectAlumnos(conexionGenerada);

System.out.println("\n\n\tID\tNombre\tApellidos\tEmail");
System.out.println("\t-----------------------------------------------");

for(AlumnoDTO alumno : listaAlumnos) {
        System.out.println(alumno.toString());
}
```

![](./img/18.png)

![](./img/19.png)

## Consulta DELETE

### *Models --> Consultas --> ConsultasPostgreSQL.java*

```java
/*************************************** CONSULTAS DELETE ******************************************/

    public static void ConsultaDeleteAlumnos(Connection conexionGenerada)
    {
        Statement declaracionSQL = null;
        ResultSet resultadoConsulta = null;
        ConexionPostgreSQL conexionPostgresql = new ConexionPostgreSQL();
        
        conexionGenerada = conexionPostgresql.generaConexion(VariablesConexionPostgreSQL.getHost(),VariablesConexionPostgreSQL.getPort(),VariablesConexionPostgreSQL.getDb(),VariablesConexionPostgreSQL.getUser(),VariablesConexionPostgreSQL.getPass());
        
        System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Realiza consulta a PostgreSQL");
        
        // pedimos un id por consola
        System.out.print("\n\tIntroduzca un alumno_id para eliminarlo:\t");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        
        if(conexionGenerada != null) {
            
            try {
                declaracionSQL = conexionGenerada.createStatement();
                resultadoConsulta = declaracionSQL.executeQuery("DELETE FROM \"EjemploInicial\".\"alumnos\" WHERE alumno_id = '"+id+"'");

                System.out.println("\n[INFORMACIÓN-Consultas-ConsultasPostgreSQL.java] Cierre del resultado, de la declaración, y de la conexión");
                
                resultadoConsulta.close();
                declaracionSQL.close();
                conexionGenerada.close();
                sc.close();

            } catch (SQLException e) {
                System.out.println("\n[ERROR-Consultas-ConsultasPostgreSQL.java] Error generando la declaracionSQL: " + e);
            }
        }
    }
```

### *(Default Package) --> App.java*

```java
/********************** Hacemos un delete del (primer) alumno con id=1 *************/
        
ConsultasPostgreSQL.ConsultaDeleteAlumnos(conexionGenerada);
        
/*********** Volvemos a obtener y mostrar la tabla alumnos de la BBDD ************/
        
listaAlumnos = new ArrayList<AlumnoDTO>();

listaAlumnos = ConsultasPostgreSQL.ConsultaSelectAlumnos(conexionGenerada);

System.out.println("\n\n\tID\tNombre\tApellidos\tEmail");
System.out.println("\t-----------------------------------------------");

for(AlumnoDTO alumno : listaAlumnos) {
    System.out.println(alumno.toString());
}
```

![](./img/20.png)

![](./img/21.png)