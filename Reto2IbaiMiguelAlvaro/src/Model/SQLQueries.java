package Model;


/*
 * faltan cosas
 */
public class SQLQueries {
	//SELECTS
	public static final String SELECT_ID_AGENCIAS = "select id_agencia from agencias where nombre = ?";
	public static final String SELECT_CONTRA_AGENCIAS = "select contraseña from agencias where nombre = ? AND contraseña = ?";
	public static final String SELECT_COLOR_AGENCIA = "select color_marca from agencias where id_agencia = ?";
	public static final String SELECT_NOMBRE_AGENCIA = "select nombre from agencias where id_agencia = ?";
	//INSERTS
	public static final String INSERT_AGENCIAS = "insert into Agencias values ('";
	public static final String SEPARATOR = "', '";
	public static final String END_BLOCK = "')";
	public static final String INSERT_VIAJE = "insert into viajes values ('";
	
}
