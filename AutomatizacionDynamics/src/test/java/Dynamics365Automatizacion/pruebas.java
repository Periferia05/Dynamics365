package Dynamics365Automatizacion;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

public class pruebas {
	
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
	private String URL = "https://periferia-it.crm2.dynamics.com/main.aspx?appid=4dbcdffd-18a1-ea11-a812-000d3ac17635&pagetype=dashboard&id=7dcdd0a9-1cc4-e911-a812-000d3ac17635&type=system&_canOverride=true";
	//private String URL = "https://outlook.office.com/mail/";
		/*@BeforeClass
	
		public static void setUpBeforeClass()
		{		
			System.setProperty(TIPO_DRIVER, PATH_DRIVER);
		}
	*/
		@Before
		public void setUP()
		{
			System.setProperty(TIPO_DRIVER, PATH_DRIVER);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			
			
		}
	
		@Test
		
		public void testSourch() throws InterruptedException, ParseException
		{
			
		
			
			WebElement LoginCorreoDynamics = driver.findElement(By.xpath("//input[@name='loginfmt']"));
			LoginCorreoDynamics.sendKeys("talkie@periferiaitgroup.com");
			Thread.sleep(3000);
				
			WebElement PasoSiguiente = driver.findElement(By.id("idSIButton9"));
			PasoSiguiente.click();
			Thread.sleep(3000);
			
			 WebElement Contraseña = driver.findElement(By.name("passwd"));
			Contraseña.sendKeys("P3r1f3r142022*");
			
			WebElement PasoSiguiente2 = driver.findElement(By.id("idSIButton9"));
			PasoSiguiente2.click();
			Thread.sleep(5000);
			
			WebElement SiMantenerSession = driver.findElement(By.id("idSIButton9"));
			SiMantenerSession.click();
			Thread.sleep(30000);
						
			WebElement btnContactos = driver.findElement(By.xpath("//*[@id=\"sitemap-entity-NewSubArea_f5d0b13b\"]/div/div/div[2]"));
			btnContactos.click();
			Thread.sleep(30000);			
			
			
				        
				        
				        
				        
				        
			 int contador = 1;
			 
					WebElement nombreCompleto = driver.findElement(By.xpath("//*[@id=\"entity_control-pcf_grid_control_container\"]/div/div[1]/div/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div["+contador+"]/div[3]/div/div/div/div[1]/div/a"));
					System.out.println("El nombre del contacto es: " + nombreCompleto.getText());			
					
					WebElement ContactoN1 = driver.findElement(By.xpath("//*[@id=\"entity_control-pcf_grid_control_container\"]/div/div[1]/div/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div/a/div/span"));
					ContactoN1.click();
					Thread.sleep(30000);
					
					WebElement fechaDeModificacion = driver.findElement(By.xpath("//*[@id=\"timeline_record_container5111be85-9a18-ec11-b6e7-000d3a886e71notescontrol\"]/div[1]/div/div[1]/div[1]"));
						
					String fechUltimoMensaje = fechaDeModificacion.getText().substring(23);
					System.out.println(fechUltimoMensaje.substring(0,10));
														
					WebElement propietario = driver.findElement(By.xpath("//div[@class='pa-a pa-af flexbox']"));
					System.out.println("el nombre del comercial es  : "+ propietario.getText());
					
					WebElement clickComercial = driver.findElement(By.xpath("//*[@id=\"headerControlsList_2\"]/div[2]/div[1]/a"));
					clickComercial.click();
					Thread.sleep(30000);
											
					WebElement correoPropietario = driver.findElement(By.xpath("//input[@data-id='domainname.fieldControl-text-box-text']"));
		            String pro = correoPropietario.getAttribute("value");
		            System.out.println("El correo del propietario : " + pro);
		            btnContactos.click();
		            Thread.sleep(2000);
		            
		            
					
					driver.get("https://outlook.office.com/mail/");
			        Thread.sleep(40000);
			        			  
			Thread.sleep(15000);
			        WebElement LoginCorreoOutlook = driver.findElement(By.xpath("//input[@name='loginfmt']"));
			        LoginCorreoOutlook.sendKeys("talkie@periferiaitgroup.com");
					Thread.sleep(15000);
					
					WebElement PasoSiguienteOutlook = driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]"));
					PasoSiguienteOutlook.click();
					Thread.sleep(15000);
					
					 WebElement ContraseñaOutlook = driver.findElement(By.name("passwd"));
					 ContraseñaOutlook.sendKeys("P3r1f3r142022*");
					 Thread.sleep(5000);

					 
					 WebElement SiguienteOutlook = driver.findElement(By.id("idSIButton9"));
					 SiguienteOutlook.click();
					 Thread.sleep(5000);
					 
						WebElement SiMantenerSession1 = driver.findElement(By.id("idSIButton9"));
						SiMantenerSession1.click();
						Thread.sleep(30000);
					
						WebElement correoeOutlook = driver.findElement(By.xpath("//*[@id=\"innerRibbonContainer\"]/div[1]/div/div/div/div[2]/div/span/button[1]/span"));
						correoeOutlook.click();
						Thread.sleep(3000);	 
						
						//String pro ="carloscanon@cbit-online.com";
						
						WebElement Para = driver.findElement(By.xpath("//*[@id=\"docking_InitVisiblePart_0\"]/div/div[4]/div[1]/div/div[4]/div/div"));
						 Para.sendKeys(pro);
						 
						 WebElement Asunto = driver.findElement(By.xpath("//*[@id=\"TextField1021\"]"));
						 Asunto.sendKeys("PruebaEnvioCorreo*");
						
						 WebElement body = driver.findElement(By.xpath("//*[@id=\"editorParent_2\"]/div/div"));
						 body.sendKeys("PruebaEnvioCorreo*");
					
						driver.get("https://periferia-it.crm2.dynamics.com/main.aspx?appid=4dbcdffd-18a1-ea11-a812-000d3ac17635&pagetype=entityrecord&etn=systemuser&id=36ef5e13-9062-e811-813a-e0071b6f7161");
				        Thread.sleep(5000);
				        
				        
				        Calendar Calendario = Calendar.getInstance();
						Date hoy = (Date) Calendario.getTime();
						Calendario.add(Calendar.DATE, -30);
						Date FechaMenosdias = (Date) Calendario.getTime(); //Fecha sin los 30 dias   29/10/2022
						
						//Date Fecha1 = diasMenos;
						
						String FechaModificacion = "18/09/2021";
					
						
						SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
						Date fechaUltimaModificacion = (Date) formato.parse(FechaModificacion);		
					
						
						
						//if(fechaUltimaModificacion < FechaMenosdias)
						//if(18/09/2021 < 29/10/2022)
						if(fechaUltimaModificacion.compareTo(FechaMenosdias)<0) {
							
							
							System.out.println("la primera fecha es "  + fechaUltimaModificacion + " esta fecha es menor a " +  FechaMenosdias);
						}
						
						
					}
					
				        
				        

			            
			

	
		
		
		
		
		private void getMensaje() {
			// TODO Auto-generated method stub
			
		}

		private void getAttribute(String string) {
			// TODO Auto-generated method stub
			
		}

		@After
		
		public void tearDown()
		{
			driver.quit();
					
		}
		
		@AfterClass
		
		public static void tearDownAfterClass()
		{
			System.out.println("finalizacion");
			
			
		}
}
