# ClipboardHealth: Coding Challenge

Amazon-Assignment
------------------------------------------------------------------------------------------------------------------------------------------------------
**Libraries Used**: 

1.Selenium - Web Automation
2.TestNG - Unit Testing Library
3.Extent Reports - Reporting Library to generate beautiful html reports
4.Assert.assertEquals - TestNG Assertion Library in Java
5.WebDriverManager - Executables management
6.Lombok - To reduce boilerplate codes
7.Build Tool used:Apache Maven
8.Test Design Pattern: Page Object Model
Note : All the above-mentioned libraries are open-source and does not include any license.
---------------------------------------------------------------------------------------------------------------------------------------------------------

Capabilities:
This framework has the capability to run the tests in Docker
Integration with Jenkins for scheduling is easy. 🙋

---------------------------------------------------------------------------------------------------------------------------------------------------------

**Running Tests**

Prerequisites: Java 8+
1. mvn clean->validate->compile

---------------------------------------------------------------------------------------------------------------------------------------------------------

**Allure Reports**:

This project has configured with allure-maven

1.Add all the allure dependencies in pom.xml 
2.Add the allure configuration in the runner class file 
3.Specify the reports directory in the runner class file 4.Add config properties file
4.Run the Test

**Pre-Requisite**:

Download allure from maven central and configure the path of allure in Environment Variables
**Example** : C:\Users\bharathibalaji.r\Desktop\allure-commandline-2.9.0\allure-2.9.0\bin

**Website to download allure**: https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/

1.Click on target/Results Directory and open the terminal 2.Enter the command allure serve 3.HTML Report will be generated.

-------------------------------------------------------------------------------------------------------------------------------------------------------------

**Allure Report Interpretation**:

Dashboard view clearly indicates the start time, end time of the run, number of tests passed and failed. It also shows the time took for the individual tests in form of timeline. Hover the mouse over the timeline to get the exact time details.

![image](https://user-images.githubusercontent.com/76836867/195310451-11ffadbc-db1f-460f-8f25-3f2a5d2c5a76.png)
