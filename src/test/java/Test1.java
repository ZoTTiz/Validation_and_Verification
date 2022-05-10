import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;

public class Test1 {
    WebDriver driver;

    @BeforeEach
    public void setUpEach() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Pesquisa no Google, para ver se abre o site escolhido.")
    public void test1(){
        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(    "zotti" + Keys.ENTER);

        driver.findElement(By.xpath("//a[@href='https://www.zotti.ind.br/']")).click();

        String urlCurrent = driver.getCurrentUrl();
        String expectedURL = "https://www.zotti.ind.br/";

        assertEquals( expectedURL, urlCurrent);
        //driver.close();
    }

    @Test
    @DisplayName("Pesquisa no Google uma imagem e ao mesmo tempo tenta selecionar a mesma e abrir o link da página.")
    public void test2(){
        driver.get("https://www.google.com/");

        //driver.findElement(By.xpath("//a[@href='https://www.zotti.ind.br/']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.google.com.br/imghp?hl=pt-BR&tab=ri&authuser=0&ogbl/']")).click();

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(    "software" + Keys.ENTER);

        driver.findElement(By.className("n3VNCb")).click();
        driver.findElement(By.xpath("//a[@href='https://canaltech.com.br/software/o-que-e-software/']")).click();

        String urlCurrent = driver.getCurrentUrl();
        String expectedURL = "https://canaltech.com.br/software/o-que-e-software/";

        assertEquals(expectedURL, urlCurrent);
        //driver.close();
    }

    @Test
    @DisplayName("Acessar a página doodles no google.")
    public void test3(){
        driver.get("https://www.google.com/");

        driver.findElement(By.className("M6CB1c rr4y5c")).click();

        driver.findElement(By.name("btnI")).click();

        driver.findElement(By.id("about-link")).click();

        String urlCurrent = driver.getCurrentUrl();
        String expectedURL = "https://www.google.com/doodles/about";

        assertEquals(expectedURL, urlCurrent);
        //driver.close();
    }

    @Test
    @DisplayName("Login inválido no MOODLE.")
    public void test4(){
        driver.get("https://moodle.utfpr.edu.br/login/index.php");

        WebElement user = driver.findElement(By.name("username"));
        user.sendKeys(    "aINVALIDO");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(    "INVALIDO");

        String urlCurrent = driver.getCurrentUrl();

        WebElement btnLogIN = driver.findElement(By.id("loginbtn"));
        btnLogIN.click();

        String expectedURL = "https://moodle.utfpr.edu.br/my/";

        assertEquals(expectedURL, urlCurrent);
        //driver.close();
    }
}

