package TodasPruebasEnvioCorreo;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class PruebasCorreo {

	
	public static void main (String [] args) throws MessagingException {		
		
		 String correo ="talkie@periferiaitgroup.com";
	     String correoDestino="carloscanon@cbit-online.com";
	     String asunto="prueba";
	     String mensajeDeTexto ="envio correo";
	     String contraseña ="P3r1f3r142022*";
	     
	     Properties p = new Properties();  
	        p.put("mail.smtp.host", "smtp-mail.outlook.com");
	        p.setProperty("mail.smtp.starttls.enable", "true");
	        p.put("mail.smtp.ssl.trust", "smtp.office365.com");
	        p.setProperty("mail.smtp.port", "587");
	        p.setProperty("mail.smtp.user",correo);
	        p.setProperty("mail.smtp.auth", "true");
	        Session s = Session.getDefaultInstance(p); 
	        BodyPart texto =new MimeBodyPart();
	        texto.setText("pruebas");
	        BodyPart adjunto =new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("")));
	        adjunto.setFileName("");
	        MimeMultipart m = new MimeMultipart();
	        m.addBodyPart(texto);
	        m.addBodyPart(adjunto);       
	        MimeMessage mensaje = new MimeMessage(s);
	        mensaje.setFrom(new InternetAddress(correo));
	        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
	        mensaje.setSubject("prueba");
	        mensaje.setContent(m);
	       
	        Transport t = s.getTransport("smtp");
			t.connect(correo,contraseña);
	          t.sendMessage(mensaje, mensaje.getAllRecipients());
	          t.close();
	          JOptionPane.showMessageDialog(null,"Mensaje enviado");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
