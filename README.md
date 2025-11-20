  **Selenium-TestNG-POM-Framework**

This is a simple and clean Selenium Automation Framework built using Java, TestNG, Page Object Model (POM), and Maven.
The project automates the login functionality of the Demo Web Shop website.

__📌 Project Overview__

This framework includes :

**•** Selenium WebDriver setup

**•** TestNG test execution

**•** Page Object Model (POM) design

**•** Base test setup and teardown

**•** A sample login test using TestNG

**•** Maven dependency management

Application under test:

https://demowebshop.tricentis.com/

__🧩 Framework Components__

**BaseTest.java**

**•** Initializes Firefox WebDriver

**•** Maximizes browser window

**•** Sets implicit wait

**•** Opens application URL

**•** Closes the browser after test execution

__LoginPage.java__

**•** Stores locators used on Login Page

**•** Handles clicking on login link

**•** Enters email

**•** Enters password

**•** Clicks login button

__LoginTest.java__

**•** Extends BaseTest

**•** Performs valid login test

**•** Validates page title

**•** Uses TestNG @Test annotation

__🛠️ Technologies Used__

**•** Java

**•** Selenium WebDriver

**•** TestNG

**•** Maven

**•** Page Object Model (POM)
