import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Added this import
import java.time.Duration;

public class PartyMonsterTest {
    public static void main(String[] args) {
        // 1. Setup Options for Automation (No hardcoded paths!)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Required: Runs without a UI on GitHub
        options.addArguments("--no-sandbox");   // Recommended for Linux environments
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues in Docker/GitHub

        WebDriver driver = new ChromeDriver(options);

        // 2. Set an Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        try {
            // 3. Navigate to the Join page
            driver.get("https://partymonster.app/join");

            // Note: Window maximize still works in headless mode to set viewport size
            driver.manage().window().maximize();

            System.out.println("Successfully reached: " + driver.getTitle());

            // 5. Verification
            if (driver.getCurrentUrl().contains("join")) {
                System.out.println("JOIN PAGE TEST: PASSED");
            } else {
                System.out.println("JOIN PAGE TEST: FAILED (Wrong URL)");
            }

        } catch (Exception e) {
            System.out.println("TEST FAILED: " + e.getMessage());
            // This ensures the GitHub Action shows a "Red X" if it fails
            throw new RuntimeException(e);
        } finally {
            // 6. Close browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}