package br.com.sicred.Teste.API;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class TestesApiViaCep {

	/**
	 * Verificando Cep Retornado com Sucesso
	 */
	@Test
	public void verificandoCepValido() {

		String uriBase = "https://viacep.com.br/ws/91060900/json/";
		
		given().relaxedHTTPSValidation()
			.when()
				.get(uriBase)
					.then().statusCode(200).contentType(ContentType.JSON)
			.body("cep", is("91060-900"))
			.body("logradouro", is("Avenida Assis Brasil 3940"))
			.body("complemento", is(""))
			.body("bairro", is("São Sebastião"))
			.body("localidade", is("Porto Alegre"))
			.body("uf", is("RS"))
			.body("unidade", is(""))
			.body("ibge", is("4314902"))
			.body("gia", is(""));
		
	}

	/**
	 * Foi verificado apenas o statusCode pois o serviço não retornava mensagem de Erro
	 */
	@Test
	public void verificandoCepInexistente() {

		String uriBase = "https://viacep.com.br/ws/91060900456454/json/";
		
		given().relaxedHTTPSValidation()
			.when()
				.get(uriBase)
					.then().statusCode(400);
			
	}
	
	/**
	 * Foi verificado apenas o statusCode pois o serviço não retornava mensagem de Erro
	 */
	@Test
	public void verificandoCepFormatoInvalido() {

		String uriBase = "https://viacep.com.br/ws/asdasdasdaasd/json/";
		
		given().relaxedHTTPSValidation()
			.when()
				.get(uriBase)
					.then().statusCode(400);
			
	}
	
	
}
