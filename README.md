# SDET Automation Framework (UI + API + CI/CD)

A scalable and maintainable **test automation framework** built using **Java, Selenium, TestNG, and RestAssured**, designed to validate **UI, API, and hybrid end-to-end flows** with CI/CD integration.

This framework follows **industry best practices** such as Page Object Model (POM), config-driven execution, parallel testing, and rich reporting with Allure.

---

## 🚀 Key Features
- UI automation using Selenium WebDriver + TestNG
- API automation using RestAssured
- Hybrid tests combining API validation + UI flows
- Page Object Model (POM) design
- ThreadLocal WebDriver for parallel execution
- Config-driven execution (env, browser, headless)
- Jenkins CI pipeline integration
- Allure reporting with screenshots on failure
- Group-based execution (smoke / regression / api / ui)

---

## 🛠 Tech Stack
- **Language:** Java 17
- **UI Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **API Automation:** RestAssured
- **Build Tool:** Maven
- **CI/CD:** Jenkins
- **Reporting:** Allure
- **Logging:** SLF4J
- **Design Pattern:** Page Object Model (POM)

---

## 🧩 Application Under Test
- **UI:** SauceDemo (https://www.saucedemo.com)
- **API:** ReqRes (https://reqres.in)

---

## 📂 Project Structure
src/test/java
├─ base → Base test & listeners
├─ config → Environment config loaders
├─ driver → WebDriver factory (ThreadLocal)
├─ pages → Page Object classes
├─ api → API client & endpoints
├─ utils → Utilities (waits, screenshots)
└─ tests
├─ ui → UI tests
├─ api → API tests
└─ hybrid → Hybrid UI + API tests

## ⚙️ Configuration
Supports runtime overrides using JVM parameters:

```bash
-Denv=qa
-Dbrowser=chrome
-Dheadless=true

Environment configs are stored under:
src/test/resources/config/

Run all tests: mvn clean test
Run smoke tests: mvn clean test -Dgroups=smoke
Run headless in CI: mvn clean test -Dbrowser=chrome -Dheadless=true

