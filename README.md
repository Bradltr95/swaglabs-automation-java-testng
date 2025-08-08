# SwagLabs Automation Suite (Java + Selenium + TestNG + Gradle)

Automated UI test suite for [Swag Labs](https://www.saucedemo.com), built using **Java**, **Selenium WebDriver**, and **TestNG**.  
This project validates key e-commerce user flows such as login, product interaction, cart handling, and checkout, and follows best practices like the **Page Object Model** (POM).

---

All test cases make use of the CookieLogin utility class to login using cookies rather than a hard UI login. This prevents test flakiness if the
Login test fails.

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
  - Organization with TestNG suites ideas: (`smoke`, `regression`)
  - Page Object Model (POM) design pattern is being used.
  - Assertions with detailed validation messages where necessary.

- **Wait Utility**
  - Organizes all fluent waits into a utitlity class to be reused during testing.

---

## Tech Stack

| Tool                        | Purpose                                                        |
|-----------------------------|----------------------------------------------------------------|
| Java                        | Programming Language                                           |
| Selenium WebDriver          | UI automation                                                  |
| TestNG                      | Test framework & grouping                                      |
| WebDriver Factory Pattern   | Implemented a WebDriver factory pattern for different browsers |
| ExtentReports (Coming Soon) | HTML reporting                                                 |
| Logger                      | Logging support                                                |

---

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
TestNG generates basic HTML reports under build/reports/tests/test/ once the tests have been run. Don't push these results in any PRs.

Ideas: Integrate ExtentReports for visual reporting

## TODO 
- Finish automation for cart checkout.
- Include reporting and CI for test running.
