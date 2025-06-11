# 🧪 SwagLabs Automation Suite (Java + Selenium + TestNG + Gradle)

Automated UI test suite for [Swag Labs](https://www.saucedemo.com), built using **Java**, **Selenium WebDriver**, and **TestNG**.  
This project validates key e-commerce user flows such as login, product interaction, cart handling, and checkout, and follows best practices like the **Page Object Model** (POM).

---

## Features

- **Login Tests**  
  - Valid and invalid login flows  
  - Logout functionality

- **Product Tests**  
  - Search and filter items  
  - Product detail page verification

- **Cart Tests**  
  - Add/remove products  
  - Validate cart contents

- **Checkout Tests**  
  - Checkout process with user details  
  - Order confirmation page validation

- **Test Structure**
  - Organized with TestNG suites (`smoke`, `regression`)
  - Page Object Model (POM) design pattern
  - Assertions with detailed validation messages

---

## Tech Stack

| Tool             | Purpose                         |
|------------------|----------------------------------|
| Java             | Programming Language             |
| Selenium WebDriver | UI automation                  |
| TestNG           | Test framework & grouping        |
| WebDriverManager | Driver management (no manual setup) |
| ExtentReports (optional) | HTML reporting              |
| Log4j (optional) | Logging support                  |

---

## Project Structure
swaglabs-automation-java-testng/
├── src/
│ ├── main/java/pages/ # Page Object classes
│ ├── main/java/utils/ # Utilities (e.g., WebDriver setup, config)
│ └── test/java/tests/ # TestNG test classes
├── testng.xml # Test suite configuration
├── build.gradle # Gradle build config
└── .gitignore

## How to Run

1. **Clone the repo**

   ```bash
   git clone https://github.com/yourusername/swaglabs-automation-java-testng.git
   cd swaglabs-automation-java-testng
   ```

2. **Run a Specific Test Suite**
Test Suites exist under the resources folder of src/test/java. See the gradle build file to see exactly how tests are being selected.
  ```bash
  ./gradlew test -Psuite=TestSuite.xml
  ```
## Reporting
TestNG generates basic HTML reports under build/reports/tests/test/

Optional: Integrate ExtentReports or Allure for enhanced visual reports
