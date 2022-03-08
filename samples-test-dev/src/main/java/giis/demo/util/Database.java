package giis.demo.util;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.dbutils.DbUtils;

//import java.io.File;
//import java.io.InputStream;

/**
 * Encapsula los datos de acceso JDBC, lectura de la configuracion
 * y scripts de base de datos para creacion y carga.
 */
public class Database extends DbUtil {
	//Localizacion de ficheros de configuracion y carga de bases de datos
	private static final String APP_PROPERTIES = "src/main/resources/application.properties";
	private static final String SQL_SCHEMA = "src/main/resources/schema.sql";
	private static final String SQL_LOAD = "src/main/resources/data.sql";
	//parametros de la base de datos leidos de application.properties (base de datos local sin usuario/password)
	private String driver;
	private String url;
	private static boolean databaseCreated=false;

	/**
	 * Crea una instancia, leyendo los parametros de driver y url de application.properties
	 */	
	public Database() {

	
		Properties prop=new Properties();
		
		
		//try (InputStream fs = this.getClass().getClassLoader().getResourceAsStream(APP_PROPERTIES)) {

		try (FileInputStream fs=new FileInputStream(APP_PROPERTIES)) {
			prop.load(fs);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		driver=prop.getProperty("datasource.driver");
		url=prop.getProperty("datasource.url");
		if (driver==null || url==null)
			throw new ApplicationException("Configuracion de driver y/o url no encontrada en application.properties");
		DbUtils.loadDriver(driver);

	}


	public String getUrl() {
		return url;
	}
	/** 
	 * Creacion de una base de datos limpia a partir del script schema.sql en src/main/properties
	 * (si onlyOnce=true solo ejecutara el script la primera vez
	 */
	public void createDatabase(boolean onlyOnce) {
		//actua como singleton si onlyOnce=true: solo la primera vez que se instancia para mejorar rendimiento en pruebas
		if (!databaseCreated || !onlyOnce) { 
			
			/*
			File f = new File("schema.sql");
			
			try {
				FileUtils.copyInputStreamToFile(this.getClass().getClassLoader().getResourceAsStream(SQL_SCHEMA),f);
			} 
			catch (IOException e) {
				
				e.printStackTrace();
			}
			executeScript("schema.sql");
			databaseCreated=true; //NOSONAR
			f.delete();
			*/
			
			
			executeScript(SQL_SCHEMA);
			databaseCreated=true; //NOSONAR
			
					
			
		}
	}
	
	
	/** 
	 * Carga de datos iniciales a partir del script data.sql en src/main/properties
	 * (si onlyOnce=true solo ejecutara el script la primera vez
	 */
	public void loadDatabase() {
		
		
		/*
		File f = new File("load.sql");
		
		try {
			FileUtils.copyInputStreamToFile(this.getClass().getClassLoader().getResourceAsStream(SQL_LOAD),f);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		executeScript("load.sql");
		databaseCreated=true; //NOSONAR
		f.delete();

		*/
		
		executeScript(SQL_LOAD);
		databaseCreated=true; //NOSONAR
		
	}

}
