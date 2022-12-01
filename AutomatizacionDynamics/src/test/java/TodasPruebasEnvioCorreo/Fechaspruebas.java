package TodasPruebasEnvioCorreo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Fechaspruebas {

	
	public static void main(String[]args) throws ParseException {
		
		Calendar Calendario = Calendar.getInstance();
		Date hoy = Calendario.getTime();
		Calendario.add(Calendar.DATE, -30);
		Date FechaMenosdias = Calendario.getTime(); //Fecha sin los 30 dias   29/10/2022
		
		//Date Fecha1 = diasMenos;
		
		String FechaModificacion = "18/09/2021";
	
		
		SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
		Date fechaUltimaModificacion = formato.parse(FechaModificacion);		
	
		
		//if(fechaUltimaModificacion < FechaMenosdias)
		//if(18/09/2021 < 29/10/2022)
		if(fechaUltimaModificacion.compareTo(FechaMenosdias)<0) {
			
			
			System.out.println("la primera fecha es "  + fechaUltimaModificacion + " esta fecha es menor a " +  FechaMenosdias);
		}
		
		
	}
	
}
//la fecha de modificacion es : Fecha de modificaci�n:  18/09/2021 12:07