import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    WebDriver driver;
    public void startBrowser(){
        System.setProperty("webdriver.firefox.geckodriver",
        "/Users/administrator/Desktop/Misc/geckodriver");
        this.driver = new FirefoxDriver();
        this.driver.get("https://www.instagram.com/");
        try {
            final WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loginFeature(){
            final String username = "/html/body/div[2]/div/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[1]/div/label/input";
            final String password = "/html/body/div[2]/div/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[2]/div/label/input";
            final String loginBtn = "/html/body/div[2]/div/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/form/div/div[3]/button/div";
            this.driver.findElement(By.xpath(username)).sendKeys(("Username"));
            this.driver.findElement(By.xpath(password)).sendKeys(("Password"));
            this.driver.findElement(By.xpath(loginBtn)).click();
            this.driver.findElement(By.xpath(username)).clear();
            this.driver.findElement(By.xpath(password)).clear();
        }

    public static void main(String[] args) {
        Main bot = new Main();
        bot.startBrowser();
        for (int i = 0; i < 30; i++) {
            bot.loginFeature();
            System.out.println("clicked");
        }
    }
}