🛒 Ecommerce Automation Framework

This is a Selenium Test Automation Framework built using Java, Maven, TestNG, and Page Object Model (POM).
The framework automates login, search, add to cart, and checkout functionalities for an e-commerce application.

📂 Project Structure
EcommerceAutomationWorkspace/
│── src/
│   ├── main/java/com/ecommerce/
│   │   ├── base/        # Base test setup (WebDriver init, config)
│   │   ├── pages/       # Page Object classes (LoginPage, ProductPage, CheckoutPage etc.)
│   │
│   ├── test/java/com/ecommerce/tests/
│       ├── LoginTest.java
│       ├── CheckoutTest.java
│       ├── SearchTest.java
│
│── test-output/         # TestNG reports
│── target/              # Build output
│── pom.xml              # Maven dependencies & build config
│── testing.xml          # TestNG suite file

⚙ Tech Stack

Java 17+

Selenium WebDriver
TestNG
Maven
Page Object Model (POM)

 How to Setup & Run Tests
1️ Clone the Repository
git clone https://github.com/rehan2352/ecommerce-automation-framework.git
cd ecommerce-automation-framework

2️ Install Dependencies
mvn clean install

3️ Run All Tests
mvn test

4️ Run Specific Suite (testing.xml)
mvn clean test -DsuiteXmlFile=testing.xml

Reports

After execution, TestNG reports will be available at:

/test-output/index.html


Open the file in any browser to view the test results.

 Features

✔️ Modular Page Object Model (POM)
✔️ Centralized WebDriver management
✔️ Cross-browser support (can be extended)
✔️ Detailed TestNG reports
✔️ Scalable and easy to maintain

 Future Enhancements

CI/CD Integration (GitHub Actions / Jenkins)

Advanced Reporting with Extent Reports

Parallel test execution with TestNG

Selenium Grid & Docker Support

 Author: Rehan
 GitHub: @rehan2352
