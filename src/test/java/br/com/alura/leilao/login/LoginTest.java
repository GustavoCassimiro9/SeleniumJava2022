package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.*;

public class LoginTest {

    private LoginPO loginPO;
    @BeforeAll
    public static void beforeAll(){

    }
    @BeforeEach
    public void beforeEach(){
        this.loginPO = new LoginPO();
    }
    @AfterEach
    public void afterEach(){
        this.loginPO.fecharPagina();
    }

    @Test
    public void DadoAsInformaçõesValidasOLoginDeveSerRealizado(){
        loginPO.PreencheFormularioDeLogin("fulano","pass");
        loginPO.SubmeteFormularioDeLogin();
        Assert.assertTrue(loginPO.VerificarUrlDaPaginaDeLogin());
        Assert.assertEquals("fulano", LoginPO.getNomeUsuarioLogado());
    }



}
