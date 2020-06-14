/**
 * 
 */
package br.com.sicred.prova;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Helper.SicredHelper;

/**
 * @author Carll
 *
 */
public class CadastroFormulario extends SicredHelper {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		iniciarAplicacaoGroceryCrud();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fecharAplicação();
	}

	@Test
	public void test() throws InterruptedException {
		selecionarComboSelectVersion("Bootstrap V4 Theme");
	
		clicarBotaoAddCustomer();
		
		preencherFormularioCadastro();
		
		clicarBotaoSalvar();
		
		verificarMensagemSucesso();
	}

}
