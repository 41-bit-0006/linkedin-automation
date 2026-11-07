# LinkedIn Automated UI Testing

This project contains automated UI tests for LinkedIn using **Selenium WebDriver**, **Java**, and **TestNG**.

---

## 📋 Project Overview

The test suite automates and validates the following LinkedIn actions:
1. **Valid Login Test**: Logs in with valid user credentials and verifies successful navigation to the home feed.
2. **Invalid Login Test**: Enters an incorrect password and verifies that the error message is displayed.
3. **Search Test**: Searches LinkedIn for a keyword (e.g., `"Software Testing"`) and verifies that search results appear.
4. **Click Search Result Test**: Clicks on the first search result and verifies navigation to the selected page/profile.
5. **Automatic Screenshots**: Automatically takes and saves a screenshot after each test in the `screenshots/` folder.

---

## ⚙️ Prerequisites

Before running the project, make sure you have the following installed on your computer:
1. **Java JDK 17** or higher:
   - Check version in terminal: `java -version`
2. **Apache Maven**:
   - Check version in terminal: `mvn -version`
3. **Google Chrome**:
   - The latest version of Google Chrome browser.
   - *Note: Selenium 4 automatically manages the ChromeDriver for you. No manual driver download is required.*
4. **IDE (Optional but recommended)**:
   - IntelliJ IDEA or Eclipse.

---

## 🔑 Step 1: Update Login Credentials

Before running the tests, enter your valid LinkedIn login details:

1. Open `src/test/java/tests/LoginTest.java`:
   - Line 18: `private final String VALID_EMAIL = "your_email@example.com";`
   - Line 19: `private final String VALID_PASSWORD = "your_password";`
2. Open `src/test/java/tests/SearchTest.java`:
   - Line 21: `private final String VALID_EMAIL = "your_email@example.com";`
   - Line 22: `private final String VALID_PASSWORD = "your_password";`

---

## 🚀 How to Run the Tests

You can run the tests using any of the following methods:

### Method 1: Run via Terminal / Command Prompt (Recommended)

1. Open your terminal or Command Prompt.
2. Navigate to the project root directory:
   ```bash
   cd C:\Users\jayat\Desktop\linekdin_automation
   ```
3. Run all tests using Maven:
   ```bash
   mvn clean test
   ```

Maven will automatically download the dependencies, compile the code, launch Chrome, and run all test cases configured in `testng.xml`.

---

### Method 2: Run via IntelliJ IDEA

1. Open the project folder in IntelliJ IDEA.
2. Wait for Maven to load dependencies (bottom right progress bar).
3. In the Project Explorer, find `testng.xml` in the root folder.
4. Right-click on `testng.xml` and select **Run 'testng.xml'**.

---

### Method 3: Run via Eclipse IDE

1. Open the project in Eclipse as an Existing Maven Project.
2. Right-click on `testng.xml`.
3. Select **Run As** > **TestNG Suite**.

---

## ⚠️ Important Note: LinkedIn Security Checkpoint (CAPTCHA)

* LinkedIn often detects automated logins and may show a **Security Checkpoint** (SMS/Email OTP or puzzle CAPTCHA).
* If this appears, the automation script **will pause for up to 90 seconds** to allow you to complete the verification manually in the open browser window.
* Once completed, the script will automatically continue running.

---

## 📁 Test Results and Screenshots

* **Console Report**: Maven and TestNG print a summary of passed and failed tests in the terminal/console window.
* **HTML TestNG Report**: After running the tests, open the detailed HTML report at:
  ```
  target/surefire-reports/index.html
  ```
  or
  ```
  target/surefire-reports/emailable-report.html
  ```
* **Screenshots**: Every test automatically captures a screenshot upon completion (labeled `PASSED` or `FAILED`). You can find them in the `screenshots/` directory.

---

## 📂 Project Structure

```
linekdin_automation/
├── pom.xml                                    # Maven configuration & dependencies
├── testng.xml                                 # TestNG test suite configuration
├── screenshots/                               # Auto-captured test execution screenshots
├── src/
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java              # WebDriver setup, teardown & screenshot utility
│           └── tests/
│               ├── LoginTest.java             # Valid and Invalid login tests
│               └── SearchTest.java            # Keyword search & result click tests
└── README.md                                  # Project documentation and guide
```
