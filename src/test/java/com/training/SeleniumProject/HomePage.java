package com.training.SeleniumProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	 static ExtentReports extent;
	 static ExtentTest HomeTest;

	public static void main(String[] args) throws InterruptedException {
		extent =new ExtentReports(System.getProperty("user.dir")+"/test-output/HomeExtentReport.html",true);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		HomeTest=extent.startTest("Application Launched Successfully");
		driver.get("https://selenium-prd.firebaseapp.com/");
		//Enter UserName
		Thread.sleep(5000);	
		WebElement Emailadd=driver.findElement(By.id("email_field"));
		Emailadd.clear();
		Emailadd.sendKeys("admin123@gmail.com");
		HomeTest.log(LogStatus.PASS, "Username Entered Successfully");
		//Enter Password
		WebElement Password=driver.findElement(By.id("password_field"));
		Password.clear();
		Password.sendKeys("admin123");
		HomeTest.log(LogStatus.PASS, "Password Entered Successfully");
		//Click on login
		WebElement login=driver.findElement(By.xpath("//button[@onclick='login()']"));
		login.click();
		Thread.sleep(3000);
		HomeTest.log(LogStatus.PASS, "User Logged in Successfully");
		WebElement HomeTab=driver.findElement(By.linkText("Home"));
		HomeTab.click();
		Thread.sleep(3000);
		
		//Enter Your Name
		WebElement Name=driver.findElement(By.id("name"));
		Name.sendKeys("Rima");
		//Enter Father Name
		WebElement FName=driver.findElement(By.id("lname"));
		FName.sendKeys("Ramesh");
		//Enter Postal Address
		WebElement Postal=driver.findElement(By.id("postaladdress"));
		 Postal.sendKeys("487789");
		//Enter Personaladdress
		 WebElement Personaladd=driver.findElement(By.id("personaladdress"));
		 Personaladd.sendKeys("SanJose");
		 HomeTest.log(LogStatus.PASS, "Name,FathersName,PostalAddress,Personaladdress entered Successfully");
		 //RadioButton
		 WebElement Female=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[5]/span[2]/input[1]"));
		 Female.click();
		 HomeTest.log(LogStatus.PASS, "Female Radio Button clicked Successfully");
		 //DropDown Select
		 Select City=new Select(driver.findElement(By.id("city")));
		 City.selectByVisibleText("MUMBAI");
		 Select course=new Select(driver.findElement(By.id("course")));
		 course.selectByVisibleText("MBA");
		 Select district=new Select(driver.findElement(By.id("district")));
		 City.selectByIndex(2);
		 Select state=new Select(driver.findElement(By.id("state")));
		 state.selectByValue("mca"); //goa
		 HomeTest.log(LogStatus.PASS, "City,Couse,district and state selected Successfully");
		 //Enter Pincode
		 WebElement Pincode=driver.findElement(By.id("pincode"));
		 Pincode.sendKeys("95054");
		 //EnterEmail
		 WebElement EmailAdd=driver.findElement(By.id("emailid"));
		 EmailAdd.sendKeys("admin123@gmail.com");
		 //Click Submit
		 Thread.sleep(5000);
		 WebElement Submit=driver.findElement(By.xpath("//button[@class='bootbutton']"));
		 Submit.click();
		 System.out.println("Submit clicked Successfully");
		 HomeTest.log(LogStatus.PASS, "Submit Button clicked Successfully");
		 //Click Swichto and handle alert
		 Thread.sleep(5000);
			WebElement SwitchTo=driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
			SwitchTo.click();
			WebElement Alert=driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
			Alert.click();
			WebElement WindowAlert=driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
			WindowAlert.click();
			Alert AlertWindow=driver.switchTo().alert();
			String AlertText=AlertWindow.getText();
			System.out.println(AlertText);
			AlertWindow.accept();
			//handle PromptAlert
			WebElement PromptAlert=driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
			PromptAlert.click();
			Alert AlertPrompt=driver.switchTo().alert();
			AlertPrompt.sendKeys("Rima");
			AlertPrompt.accept();
			HomeTest.log(LogStatus.PASS, "Prompt box handled Successfully");
			extent.endTest(HomeTest);
			extent.flush();
			extent.close();
			
	}

}
