package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPO {

    private static final String URL_LOGIN = "http://localhost:8080/leiloes";
    private static WebDriver driver;
    public LoginPO(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.navigate().to(URL_LOGIN);
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS).pageLoadTimeout(5,TimeUnit.SECONDS);
    }

    public static Object getNomeUsuarioLogado() {
        return driver.findElement(By.cssSelector("div.logo-container span[class=font-italic]")).getText();
    }

    public void PreencheFormularioDeLogin(String usuario, String senha){
        driver.findElement(By.cssSelector("a.text-light")).click();
        driver.findElement(By.cssSelector("input[placeholder=usuário]")).sendKeys(usuario);
        driver.findElement(By.cssSelector("input[placeholder=senha]")).sendKeys(senha);

    }

    public void SubmeteFormularioDeLogin() {
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }
    public void fecharPagina() {
        this.driver.quit();
    }
    public boolean VerificarUrlDaPaginaDeLogin() {
        return driver.getCurrentUrl().equals(URL_LOGIN);
    }
}
