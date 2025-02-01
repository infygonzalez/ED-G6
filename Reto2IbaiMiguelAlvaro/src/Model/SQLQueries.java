package Model;


/*
 * faltan cosas
 */
public class SQLQueries {
	//SELECTS AGENCIA
	public static final String SELECT_ID_AGENCIAS = "select id_agencia from agencias where nombre = ?";
	public static final String SELECT_CONTRA_AGENCIAS = "select contraseña from agencias where nombre = ? AND contraseña = ?";
	public static final String SELECT_COLOR_AGENCIA = "select color_marca from agencias where id_agencia = ?";
	public static final String SELECT_NOMBRE_AGENCIA = "select nombre from agencias where id_agencia = ?";
	
	//SELECTS VIAJE
	public static final String SELECT_DATOS_VIAJE = "SELECT v.nombre, v.descripcion, v.tipo_viaje, v.fecha_inicio, v.fecha_fin, v.duracion, \n"
			+ "       p.id AS id_pais, p.nombre AS nombre_pais, \n"
			+ "       v.servicios_no_incluidos\n"
			+ "FROM viajes v\n"
			+ "JOIN paises p ON v.pais_destino = p.id\n"
			+ "WHERE v.id_agencia = ?;";
	//SELECTS EVENTO
	
	
	//INSERTS
	public static final String INSERT_AGENCIAS = "insert into Agencias values ('";
	public static final String SEPARATOR = "', '";
	public static final String END_BLOCK = "')";
	public static final String INSERT_VIAJE = "INSERT INTO viajes (nombre, descripcion, tipo_viaje, fecha_inicio, fecha_fin, duracion, pais_destino, servicios_no_incluidos, agencia)\n"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
}
