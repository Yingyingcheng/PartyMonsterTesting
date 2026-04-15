# PartyMonsterTesting Suite 

Automated functional verification and uptime monitoring for the PartyMonster platform.

## 🚀 Overview
This repository manages an automated testing suite designed to verify the "Join" flow of the PartyMonster application at `https://partymonster.app/join`. It ensures the page is reachable and functioning correctly using **Selenium WebDriver**.

## 🛠 Tech Stack
- **Language:** Java 17
- **Automation:** Selenium 4.18.1
- **Build Tool:** Maven 3.x
- **CI/CD:** GitHub Actions (cron-job)
- **Environment:** Headless Chrome on Ubuntu-latest

## 📂 Project Structure
- `.github/workflows/check-server.yml`: The automation engine handling the 6-hour schedule and manual triggers.
- `PartyMonsterTest.java`: The core Java test class containing the Selenium logic.
- `pom.xml`: Defines dependencies and the main class for Maven execution.

## 🤖 Automation Details
The test runs automatically to ensure the service is always reachable without manual intervention.

* **Schedule:** `0 */6 * * *` (Runs every 6th hour)
* **Manual Trigger:** Enabled via the "Actions" tab on GitHub (workflow_dispatch).
* **Target URL:** `https://partymonster.app/join`
* **Validation:** Confirms the page title is retrieved and the URL contains "join" to verify successful navigation.

## ⚙️ Configuration
The test is optimized for high-stability execution in CI/CD environments:
- **Performance:** Runs in `--headless=new` mode for maximum speed and compatibility.
- **Stability:** Includes `--no-sandbox` and `--disable-dev-shm-usage` for reliable execution in GitHub's containerized runners.
- **Timeouts:** Uses a 20-second implicit wait to account for network variability.

## 💻 Local Execution
To run the test manually on your local machine:
1. Ensure you have **JDK 17** and **Maven** installed.
2. Run the following command:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="PartyMonsterTest"