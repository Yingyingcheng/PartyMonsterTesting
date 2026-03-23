import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class PartyMonsterTest {
    public static void main(String[] args) {
        // 1. Setup Driver (Using your Mac path)
        System.setProperty("webdriver.chrome.driver", "/Users/yingyingcheng/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        // 2. Set an Implicit Wait (Better than Thread.sleep for modern apps)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        try {
            // 3. Navigate to the Join page
            driver.get("https://partymonster.app/join");
            driver.manage().window().maximize();

            // 4. Fill out the form (Replace "example_id" with actual IDs found via Inspect)
            // Example: driver.findElement(By.id("email")).sendKeys("test@example.com");

            System.out.println("Successfully reached: " + driver.getTitle());

            // 5. Verification
            if (driver.getCurrentUrl().contains("join")) {
                System.out.println("JOIN PAGE TEST: PASSED");
            }

        } catch (Exception e) {
            System.out.println("TEST FAILED: " + e.getMessage());
        } finally {
            // 6. Close browser
            driver.quit();
        }
    }
}
