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

    /*@BeforeAll
    public void setUpAll(){
    }*/

    @BeforeEach
    public void setUpEach() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Pesquisa no Google, para ver se abre o site escolhido")
    public void test1(){
        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(    "zotti" + Keys.ENTER);

       // driver.findElement(By.linkText("Telefone")).click();
        driver.findElement(By.xpath("//a[@href='https://www.zotti.ind.br/']")).click();

        String urlCurrent = driver.getCurrentUrl();
        String expectedURL = "https://www.zotti.ind.br/";

        assertEquals( expectedURL, urlCurrent);

        //driver.close();
    }

    @Test
    @DisplayName("Login invalido no MOODLE")
    public void test2(){
        driver.get("https://moodle.utfpr.edu.br/login/index.php");

        WebElement user = driver.findElement(By.name("username"));
        user.sendKeys(    "aINVALIDO" + Keys.ENTER);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(    "INVALIDO" + Keys.ENTER);

        String urlCurrent = driver.getCurrentUrl();

        WebElement btnLogIN = driver.findElement(By.id("loginbtn"));
        btnLogIN.click();

        String expectedURL = driver.getCurrentUrl();

        assertEquals(expectedURL, urlCurrent);
        //driver.close();
    }
}

