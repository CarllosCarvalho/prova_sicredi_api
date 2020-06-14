package Helper;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SicredHelper {
	WebDriver driver;
	WebDriverWait wait;
	
	
	/**
	 * Iniciando Aplicação
	 */
	
	protected void iniciarAplicacaoGroceryCrud(){
		System.setProperty("webdriver.chrome.driver", "C:\\DriverSelenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}
	
	/**
	 * Fechando Aplicação
	 */
	protected void fecharAplicação(){
		driver.quit();
	}
	
	/**
	 * Selecionando Combo Select Version
	 * @param valorCombo
	 */
	protected void selecionarComboSelectVersion(String valorCombo) {
		
		wait  = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("switch-version-select")));
		
		Select select = new Select(driver.findElement(By.id("switch-version-select")));
		select.selectByVisibleText(valorCombo);
	}
	
	
	/**
	 * Clicando Botão Add Customer
	 */
	protected void clicarBotaoAddCustomer() {
		
		driver.findElement(By.linkText("Add Customer")).click();
		
	}
	
	/**
	 * Clicando Botão Salvar
	 */
	protected void clicarBotaoSalvar() {
		
		driver.findElement(By.id("form-button-save")).click();
		
	}
	
	/**
	 * Preenchendo Formulario de Cadastro
	 * @throws InterruptedException
	 */
	protected void preencherFormularioCadastro() throws InterruptedException {
		
		wait  = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("field-customerName")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
		driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
		driver.findElement(By.id("field-contactFirstName")).sendKeys("seu nome");
		driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
		driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
		driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
		driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
		driver.findElement(By.id("field-state")).sendKeys("RS");
		driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
		driver.findElement(By.id("field-country")).sendKeys("Brasil");
		
		driver.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
		
		Actions acao = new Actions(driver);
		acao.sendKeys("Fixter").perform();
		acao.sendKeys(Keys.ENTER).perform();
		acao.sendKeys(Keys.TAB).perform();
		acao.sendKeys("200").perform();
		
	}
	
	
	/**
	 * Verificando mensagem de sucesso
	 */
	protected void verificarMensagemSucesso(){
		wait  = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));
		
		String textoMsg = driver.findElement(By.id("report-success")).getAttribute("innerHTML");
		String mensagemSucesso = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
		
		String valorSequencial = textoMsg.substring(textoMsg.indexOf("edit/")+5, textoMsg.indexOf(">Edit")-1);
		
		String msgFormatada = textoMsg.replace("<p>", "").replace("<a class=\"go-to-edit-form\"", "").replace("href=\"/demo/bootstrap_theme_v4/edit/", "")
		.replace("</a>", "").replace("<a href=\"/demo/bootstrap_theme_v4/\">", "").replace("</p>", "").replace(valorSequencial.toString(), "").replace(" \">", "");
		
		System.out.println(msgFormatada);
		System.out.println(mensagemSucesso);
		
		assertEquals("verificarMsgSucesso",mensagemSucesso.toString(), msgFormatada.toString());
	}
	
}
