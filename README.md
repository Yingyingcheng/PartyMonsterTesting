# PartyMonster Testing Suite

Automated Selenium testing suite designed to monitor the PartyMonster application flow.

## 🚀 Overview
This repository contains automated tests to verify the functionality of the PartyMonster join page. It is built using **Java 17**, **Maven**, and **Selenium WebDriver**.

## 📂 Project Structure
* `PartyMonsterTest.java`: The main Selenium script that performs navigation and URL verification.
* `.github/workflows/`: Contains the YAML configuration for automated GitHub Actions runs.
* `pom.xml`: Manages project dependencies, specifically the Selenium Java library.

## 🛠 Setup & Local Running
### Prerequisites
* Java JDK 17
* Maven 3.x
* Google Chrome

### Run the Test
To execute the test suite locally, run the following command in your terminal:
```bash
mvn clean compile exec:java -Dexec.mainClass="PartyMonsterTest"