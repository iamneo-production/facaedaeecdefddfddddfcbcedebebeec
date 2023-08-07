package com.examly.springapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SpringApplicationTests {

    public static void main(String[] args) {
		try{
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://34.85.242.216:4444"), chromeOptions);
        
        driver.manage().window().maximize();
        driver.get("http://www.snapdeal.com");
            // Move to Sign In Button and hold
            WebElement signInButton = driver.findElement(By.xpath("//div[@class='accountInner']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(signInButton).perform();
            
            // Move to the Sign In button and click
            WebElement signInLink = driver.findElement(By.xpath("//a[contains(text(),'login')]"));
            actions.moveToElement(signInLink).click().perform();
            
            // Switch to the login iframe
            driver.switchTo().frame("loginIframe");
            
            // Enter a valid Email Id and click continue
            WebElement emailInput = driver.findElement(By.id("userName"));
            emailInput.sendKeys("your_valid_email@example.com");
            
            WebElement continueButton = driver.findElement(By.id("checkUser"));
            continueButton.click();
            
            // Enter the valid password and click LOGIN
            WebElement passwordInput = driver.findElement(By.id("j_password_login_uc"));
            passwordInput.sendKeys("your_valid_password");
            
            WebElement loginButton = driver.findElement(By.id("submitLoginUC"));
            loginButton.click();
            
            // Switch back to the main content
            driver.switchTo().defaultContent();
            
            // Verify that the user is logged in successfully (you can add your verification logic here)
            WebElement loggedInUser = driver.findElement(By.xpath("//div[@class='myAccountTab accountHeaderClass']"));
            if (loggedInUser.getText().contains("Your Account")) {
                System.out.println("User logged in successfully.");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
