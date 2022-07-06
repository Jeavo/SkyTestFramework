# Sky Automation Framework - Setup Guide

>There is a PDF within the framework folder which contains these steps with images

<br>


## Installing basic applications

  - Download and Install [Eclipse IDE](https://www.eclipse.org/downloads/)
    > If installing -  **select Eclipse IDE for Java Developers**
  - Download and Install Google Chrome
  - Ensure Java is downloaded and installed
  - Download the framework from the Git Repository

<br>


## Once Eclipse is setup
- Right click ***Sky Framework*** in Project Explorer and select ***Properties***
- Select ***Java Compiler*** and ensure that ***Compliance Level*** is ***1.7***
- Ensure tha the GBP values on both the ***Deals.java*** and ***DealsPage.java*** class are correct and not an unknown symbol
### You must now install the relevant libraries

- Select the ***Help*** button at the top of Eclipse
- Select ***Elipse Marketplace*** from the dropdown

### Ensure the following are installed:
*You should be able to install these using the search option within the libraries module that is open*
- Buildship Gradle Integration [Marketplace Page](https://marketplace.eclipse.org/content/buildship-gradle-integration)

- Cucumber Eclipse Plugin [Marketplace Page](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin)

- Eclipse JST Server Adapters [Marketplace Page](https://marketplace.eclipse.org/content/eclipse-jst-server-adapters-apache-tomcat-jonas-j2ee)

- Mylyn WikiText [Marketplace Page](https://marketplace.eclipse.org/content/mylyn-wikitext)

- TestNG for Eclipse [Marketplace Page](https://marketplace.eclipse.org/content/testng-eclipse)

<br>


## Running the tests
- Select the ***Dropdown Arrow*** next to the ***Green Play Button*** at the top of the application
- Select ***RunTest*** with JUnit
- When the test has finished
- Navigate to the folder in which the framework is located
- There will be a file named "Cucumber Reports"
- Change this file to HTML and open it with any browser to view the test report
  
---
<br>

# Troubleshooting
There may be errors within the problems pane at the bottom of Eclipse 
<br>
Please follow the below steps to resolve these issues

### Assert Class Issues
- Highlight over the ***Assert*** text and select "Import TestNG Library"

### Cannot Switch On a Value Type of String
- Select Sky Framework in Project Explorer
- Select Properties
- Select Java Compiler
- Ensure the Compiler Compliance Level is ***1.7***

### GBP £ Symbol Displaying Incorrectly
- Within both the Deals.java and DealsPage.java classes there are GBP symbols that may not port across correctly
- They will need to be changed to the correct symbol as follows

```java

	//Element declarations
	By skyQButton = By.xpath("//span[contains(.,'Sky Q')]");
	
	By offer1Name = By.xpath("//p[contains(.,'Sky Q, Sky TV & Netflix')]");
	By offer1Value = By.xpath("//span[contains(.,'£26')]");
	
	By offer2Name = By.xpath("//p[contains(.,'Sky Q, Sky TV, Netflix & Sky Sports')]");
	By offer2Value = By.xpath("//span[contains(.,'£46')]");

	By offer3Name = By.xpath("//p[contains(.,'Sky Q, Sky TV, Netflix & Cinema')]");
	By offer3Value = By.xpath("//span[contains(.,'£38')]");


    //Asserts deals are as expected
    String expOffer1Value = "£26";
    boolean checkOffer1 = deals.returnOffer1Value(driver).contains(expOffer1Value);
    Assert.assertEquals(true, checkOffer1);
    
    String expOffer2Value = "£46";
    boolean checkOffer2 = deals.returnOffer2Value(driver).contains(expOffer2Value);
    Assert.assertEquals(true, checkOffer2);
    
    String expOffer3Value = "£38";
    boolean checkOffer3 = deals.returnOffer3Value(driver).contains(expOffer3Value);
    Assert.assertEquals(true, checkOffer3);

```

