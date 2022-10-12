# ClipboardHealth-Assignment

**Automation Framework Used:** TestNG
**Build Tool used** :Apache Maven
**Test Design Pattern**: Page Object Model
**TestNG Annotations Implementation**: @Before Method, @Test, @After Method
**Test Automation Reports**: Allure Reports and Extent Reports

**Steps to run the Tests**
1. mvn clean->validate->compile

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

**Allure report**:
![image](https://user-images.githubusercontent.com/76836867/195310451-11ffadbc-db1f-460f-8f25-3f2a5d2c5a76.png)
