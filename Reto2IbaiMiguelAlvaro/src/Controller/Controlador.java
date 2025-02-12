package Controller;
import Model.gestorAgencias;

import java.awt.Color;

import Model.Agencia;
public class Controlador {

	public void comprobarAgencia(Agencia Agencia) {
		gestorAgencias gestorAgencias = new gestorAgencias();
		gestorAgencias.comprobarAgencia(Agencia);
	}
	public void crearAgencia(Agencia agencia) {
		gestorAgencias gestorAgencias = new gestorAgencias();
		gestorAgencias.crearAgencia(agencia);
	}
	public static boolean validacionColor(String color) {
	    // Eliminar espacios en blanco antes y después del valor
	    color = color.trim();
	    
	    // Expresión regular para validar color hexadecimal
	    String regex = "^#?([a-fA-F0-9]{3}){1,2}$"; // Soporta 3 o 6 caracteres hexadecimales
	    
	    // Validación usando la expresión regular
	    if (color.matches(regex)) {
	        try {
	            // Si es válido, decodificarlo (elimina el '#' si es necesario)
	            if (color.startsWith("#")) {
	                Color.decode(color);
	            } else {
	                Color.decode("#" + color); // Añadir '#' si no lo tiene
	            }
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	    
	    return false;
	}
	
}
