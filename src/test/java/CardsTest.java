import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsTest {
    private WebDriver driver;

   @BeforeAll
    static void setUpAll() {

       System.setProperty("webdriver.chrome.driver","driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {

       driver = new ChromeDriver();
    }

    @AfterEach
    public void close() {
       driver.quit();
       driver = null;
    }

    @Test
    public void testik() {
       driver.get("http://localhost:9999");
       driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Ксюша молодец");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79995678899");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector(".button__text")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();

        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",text.trim());
    }
}
