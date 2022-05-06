import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;

public class Test1 {
    @Test
    @DisplayName("Pesquisa no Google, para ver se abre o site escolhido")
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Antonio/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

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
}
