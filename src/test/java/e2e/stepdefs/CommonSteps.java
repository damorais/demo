package e2e.stepdefs;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
	
	WebDriver driver;
	
	
	public static Map<String, String> mapaUrls(){
		Map<String, String> mapaUrls = new HashMap<String, String>();
		
		mapaUrls.put("Novo Tópico", "http://localhost:3000/topicos/create");
		
		return mapaUrls;
	}
	
	@When("Acesso a home page da aplicação")
	public void acesso_a_home_da_aplicacao() {
		driver = new PhantomJSDriver();
		driver.get("http://localhost:3000/");
	}
	
	@Then("Eu devo ver uma mensagem de boas vindas dizendo {string}")
	public void ver_mensagem_de_boas_vindas(String mensagemEsperada) {
		String textoEncontrado = 
				driver
				.findElement(By.tagName("body"))
				.findElement(By.id("boas-vindas"))
				.getText();
		
		assertEquals(mensagemEsperada, textoEncontrado);
	}
	
	@Given("Estou na página inicial da minha aplicação")
	public void estou_na_pagina_inicial_da_aplicacao() {
		driver = new PhantomJSDriver();
		driver.get("http://localhost:3000/");
	}
	
	@When("Eu clico no link {string}")
	public void clico_no_link(String textoLink) {
		driver.findElement(By.linkText(textoLink)).click();
	}
	
	@Then("Devo ser redirecionado para a página {string}")
	public void devo_ser_direcionado_para(String tituloDaPagina) {
		assertEquals(tituloDaPagina, driver.getTitle());
	}
	
	@Given("Estou na página {string}")
	public void estou_na_pagina(String pagina) {
		
		String url = mapaUrls().get(pagina);
		
		driver = new PhantomJSDriver();
		driver.get(url);
	}
	
	@When("Eu preencho os dados de um novo tópico")
	public void preencher_novo_topico() {
		driver
		.findElement(By.id("titulo"))
		.sendKeys("Como fazer batata frita?");
		
		driver
		.findElement(By.id("descricao"))
		.sendKeys("Preciso de uma receita bacana de como fazer batata frita");
	}
	
	@And("Eu clico em {string}")
	public void clico_em(String rotulo) {
		driver
		.findElement(By.xpath("//button[normalize-space()='" + rotulo + "']"))
		.click();
	}
	
	@Then("Devo ser redirecionado para a página do tópico")
	public void fui_redirecionado_para_pagina_topico() {
		String titulo = driver
						.findElement(By.id("titulo"))
						.getText();
		String descricao = driver
						   .findElement(By.id("descricao"))
						   .getText();
				
		assertEquals("Como fazer batata frita?", titulo);
		assertEquals("Preciso de uma receita bacana de como fazer batata frita", descricao);
	}
	
	
}
