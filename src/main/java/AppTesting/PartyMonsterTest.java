package AppTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PartyMonsterTest {
    public static void main(String[] args) {
        System.out.println("=== TEST STARTING ===");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = null;

        try {
            System.out.println("STEP 1: Initializing Chrome Driver...");
            driver = new ChromeDriver(options);

            System.out.println("STEP 2: Setting timeouts...");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            System.out.println("STEP 3: Navigating to PartyMonster...");
            driver.get("https://partymonster.app/join");

            System.out.println("STEP 4: Page Title is: " + driver.getTitle());

            if (driver.getCurrentUrl().contains("join")) {
                System.out.println("RESULT: JOIN PAGE TEST PASSED");
            } else {
                System.out.println("RESULT: JOIN PAGE TEST FAILED - URL mismatch");
            }

        } catch (Exception e) {
            System.out.println("!!! ERROR DETECTED !!!");
            e.printStackTrace(); // This is the most important line!
        } finally {
            if (driver != null) {
                System.out.println("STEP 5: Closing browser...");
                driver.quit();
            }
            System.out.println("=== TEST FINISHED ===");
        }
    }
}