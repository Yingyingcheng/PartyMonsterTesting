package AppTesting; // MUST match your folder name

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class PartyMonsterTest {
    public static void main(String[] args) {
        // IMPORTANT: No System.setProperty for ChromeDriver here!

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");      // Required for GitHub
        options.addArguments("--no-sandbox");        // Required for Linux
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory crashes
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        try {
            System.out.println("Starting test...");
            driver.get("https://partymonster.app/join");

            System.out.println("Page Title: " + driver.getTitle());

            if (driver.getCurrentUrl().contains("join")) {
                System.out.println("JOIN PAGE TEST: PASSED");
            }
        } catch (Exception e) {
            System.out.println("CRASH DURING TEST: " + e.getMessage());
            e.printStackTrace(); // This sends the details to the GitHub log
            System.exit(1);      // Tells GitHub the test failed
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}