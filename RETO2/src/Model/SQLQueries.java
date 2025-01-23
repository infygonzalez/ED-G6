package Model;
/*
 * faltan cosas
 */
public class SQLQueries {
	//SELECTS
	public static final String SELECT_NOMBRE_AGENCIAS = "select nombre from Agencias where nombre = ?";
	public static final String SELECT_CONTRA_AGENCIAS = "select contrase from Agencias where nombre = ? contrase = ?";
	//INSERTS
	public static final String INSERT_AGENCIAS = "insert into Agencias values ('";
	public static final String SEPARATOR = "', '";
	public static final String END_BLOCK = "')";
}
