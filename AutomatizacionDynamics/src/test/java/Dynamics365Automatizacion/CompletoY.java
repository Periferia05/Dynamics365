package Dynamics365Automatizacion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class CompletoY {

    String name = "";
    String correoPropietarioWeb = "";
    String fechaWeb = "";

    private WebDriver driver;
    ///private static final String TIPO_DRIVER = "webdriver.chrome.driver";
    ///private static final String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
    private String URL = "https://periferia-it.crm2.dynamics.com/main.aspx?appid=4dbcdffd-18a1-ea11-a812-000d3ac17635&pagetype=dashboard&id=7dcdd0a9-1cc4-e911-a812-000d3ac17635&type=system&_canOverride=true";
    /*@BeforeClass
    public static void setUpBeforeClass()
    {
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);
    }
*/
    @Before
    public void setUP()
    {
        WebDriverManager.chromedriver().setup();
        ///System.setProperty(TIPO_DRIVER, PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @Test
    public void testSourch() throws InterruptedException, ParseException {
        // Fijamos la espera implicita a 10 segundos
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        // LOGIN
        By txtCorreo = By.cssSelector("#i0116");
        esperaFluidaSenkeys(txtCorreo, "talkie@periferiaitgroup.com");

        By btnSiguiente = By.cssSelector("#idSIButton9");
        esperaFluidaClic(btnSiguiente);
        Thread.sleep(1000);

        By txtContrasenia = By.cssSelector("#i0118");
        esperaFluidaSenkeys(txtContrasenia, "P3r1f3r142022*");

        By btnSiguiente2 = By.cssSelector("#idSIButton9");
        esperaFluidaClic(btnSiguiente2);

        // ACEPTAR ALERTAS
        Thread.sleep(500);
        By siMantenerSession = By.cssSelector("#idSIButton9");
        esperaFluidaClic(siMantenerSession);

        //Thread.sleep(5500);

        // CONTACTOS
        By btnContactos = By.cssSelector("div[title='Contactos']");
        esperaFluidaClic(btnContactos);

        Thread.sleep(5000);
        // OBTENER CANTIDAD DE USUARIOS
        WebElement labelTotalUser = driver.findElement(By.cssSelector(".statusContainer-145"));
        String totalUserString = labelTotalUser.getText().substring(10, 14);
        // convertir de String a  int
        int totalUser = Integer.valueOf(totalUserString);
        System.out.println("El total de usuario es: "+ totalUser);

        int userCompilados = 1;
        int contadorPaginas = 0;
        boolean mensajePagina = false;


        System.out.println("********************* Esta en la: Página 1" );

        for (int i = 1; i <= 1; i++) {

            int contador = 15;
            int contador2 = contador + contador;
            int contador3 = contador2 + contador;

            // Toda la compilación de los usuarios(3569) hasta la última página 72 por el momento
            if ( userCompilados <= 72 ) {

                // Salto de página una vez que el contador llega a 50 - Actualización de Página
                if (mensajePagina == true) {

                    Thread.sleep(1000);
                    contadorPaginas += 1;
                    siguientePagina(contadorPaginas);

                }

                System.out.println(i);
                // Condicionales para hacer visible al elemento usuario
                if (i >= 16 && i < 30) {

                    elementoVisible(contador);

                } else if (i >= 30 && i < 45) {

                    elementoVisible(contador);
                    elementoVisible(contador2);

                } else if (i >= 45) {

                    elementoVisible(contador);
                    elementoVisible(contador2);
                    elementoVisible(contador3);

                }

                // SELECCIONAR USUARIO
                By selectUser = By.cssSelector("div[row-index='"+(i-1)+"'] div[col-id='fullname'] a[role='link']");
                esperaFluidaCapturarTexto(selectUser);


                // SELECCIONAR PROPIETARIO
               // Thread.sleep(500);
                By propietario = By.cssSelector("div[class='pa-a pa-af flexbox']");
                esperaFluidaCapturarTexto(propietario);
                System.out.println("El nombre del propietario es: " + name);

                // OBTENER CORREO PROPIETARIO
                Thread.sleep(1000);
                By correoPropietario = By.cssSelector("input[data-id='domainname.fieldControl-text-box-text']");
                esperaFluidaCapturarAtributo(correoPropietario);

                // VOLVER 1
                By flechaVolver = By.cssSelector("#navigateBackButtontab-id-0");
                esperaFluidaClic(flechaVolver);

                // OBTENER FECHA - VALIDACIÓN SI EL ELEMENTO ES VISIBLE O NO
                List<WebElement> dynamicElement = driver.findElements(By.cssSelector("div[title^='Fecha de modificación']"));
                WebElement flechaVolver2 = driver.findElement(By.cssSelector("#navigateBackButtontab-id-0"));
                if (dynamicElement.size() != 0){
                    System.out.println("Existe elemento");
                    WebElement fecha = driver.findElement(By.cssSelector("div[title^='Fecha de modificación']"));
                    fechaWeb = fecha.getText().substring(23,33);
                    System.out.println("La fecha web es:" + fechaWeb);
                    // llamado método
                    fecha(fechaWeb);
                    //System.out.println(fecha.getText());
                    flechaVolver2.click();
                } else { //0, elemento no esta presente.
                    System.out.println("Elemento no existe");
                    flechaVolver2.click();
                }

                // Reinicio de contador, para los usuarios de la siguiente página
                if ( i == 1 ) {
                    i = 0;
                    mensajePagina = true;
                } else  {
                    mensajePagina = false;
                }

                System.out.println("El total de usuarios compilados  es: " + userCompilados);
                userCompilados = userCompilados + 1;
            }// fin if

        } // fin for


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

    //-------------------------------------------------------------------------------------------------//
    //                              MÉTODOS
    //-------------------------------------------------------------------------------------------------//

    /**
     * Método para refrescar la página, va a hacer clic en el número de la página
     * @param contadorPaginas
     * @throws InterruptedException
     */
    public  void siguientePagina(int contadorPaginas) throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(4000);

        // CICLO - CLIC HASTA LLEGAR AL NUMERO DE LA PAGINA 2-3-4-5-6-7-8
        WebElement paginaSiguiente2 = driver.findElement(By.cssSelector("button[aria-label='Página siguiente']"));
        for (int j = 0; j < contadorPaginas; j++) {
            paginaSiguiente2.click();
            Thread.sleep(1200);
        }

        Thread.sleep(1000);
        WebElement numPagina = driver.findElement(By.cssSelector(".pageNumberLabel-153"));
        String numeroPagina =  numPagina.getText().substring(0, 9);
        System.out.println();
        System.out.println("********************* Pasas a la: " + numeroPagina);
    }

    /**
     * Método para hacer visible el elemento por medio de JavascriptExecutor - scroll
     * @param contador
     */
    public void elementoVisible(int contador){
        WebElement selectUser = driver.findElement(By.cssSelector("div[row-index='"+contador+"'] div[col-id='fullname']"));
        // Elemento visible - Scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", selectUser);
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void esperaFluidaClic(final By selector){

        // WebDriverWait fwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(59))
                .pollingEvery(Duration.ofMillis(160))
                .ignoring(NoSuchElementException.class);

        try {
            WebElement guardaElemento = fwait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(selector);
                }
            });
            //assertTrue(driver.findElement(selector).isDisplayed()); //confirma si el selector está presente en la página
            guardaElemento.click();
            System.out.println("Clic hecho");
        } catch (Exception e){
            System.out.println(e);
        }
    }



    public void esperaFluidaSenkeys(final By selector, String palabra){

        // WebDriverWait fwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(59))
                .pollingEvery(Duration.ofMillis(160))
                .ignoring(NoSuchElementException.class);

       try {
           WebElement guardaElemento = fwait.until(new Function<WebDriver, WebElement>() {
               public WebElement apply(WebDriver driver) {
                   return driver.findElement(selector);
               }
           });
           //assertTrue(driver.findElement(selector).isDisplayed()); //confirma si el selector está presente en la página
           guardaElemento.sendKeys(palabra);
           System.out.println("Palabra enviada");
       } catch (Exception e){
           System.out.println(e);
       }
    }

    public void esperaFluidaCapturarTexto(final By selector){

        // WebDriverWait fwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(59))
                .pollingEvery(Duration.ofMillis(160))
                .ignoring(NoSuchElementException.class);

        try {
            WebElement guardaElemento = fwait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(selector);
                }
            });
            //assertTrue(driver.findElement(selector).isDisplayed()); //confirma si el selector está presente en la página
            name = guardaElemento.getText();
            System.out.println("El nombre del contacto es: " + name);
            guardaElemento.click();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void esperaFluidaCapturarAtributo(final By selector){

        // WebDriverWait fwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(59))
                .pollingEvery(Duration.ofMillis(160))
                .ignoring(NoSuchElementException.class);

        try {
            WebElement guardaElemento = fwait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(selector);
                }
            });
            //assertTrue(driver.findElement(selector).isDisplayed()); //confirma si el selector está presente en la página
            correoPropietarioWeb = guardaElemento.getAttribute("Value");
            System.out.println("El correo del propietario : " + correoPropietarioWeb);
            guardaElemento.click();
        } catch (Exception e){
            System.out.println(e);
        }
    }


    // METODO VALIDACION FECHA

    public void fecha (String fechaWeb) throws ParseException {
            Calendar Calendario = Calendar.getInstance();
            Date hoy = Calendario.getTime();
            Calendario.add(Calendar.DATE, -30);
            Date FechaMenosdias = Calendario.getTime(); //Fecha sin los 30 dias   29/10/2022
            //Date Fecha1 = diasMenos;
            String FechaModificacion = fechaWeb;
            SimpleDateFormat formato =new SimpleDateFormat("dd/MM/yyyy");
            Date fechaUltimaModificacion = formato.parse(FechaModificacion);
            //if(fechaUltimaModificacion < FechaMenosdias)
            //if(18/09/2021 < 29/10/2022)
            // 18/09/2021 < 29/10/2022
            if(fechaUltimaModificacion.compareTo(FechaMenosdias)<0) {
                System.out.println("Validación correcta (ENVIA CORREO) " );
            } else {
                System.out.println("Validación correcta ( NO ENVIA CORREO) ");
            }
    }



}