package Guvitask22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AutomateForm {


	public static void main(String[] args) {

		 WebDriver driver = new ChromeDriver();
	    
	     Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	    		      
	     
	        try {
	            // Step 1: Go to the form page
	            String formUrl = "https://phptravels.com/demo/";
	            driver.get(formUrl);
	            
	            // Step 2: Fill in the form details
	            WebElement nameField = driver.findElement(By.name("name"));
	            nameField.sendKeys("John");

	            WebElement emailField = driver.findElement(By.name("email"));
	            emailField.sendKeys("john1@gmail.com");

	            // Step 3: Add logic for sum verification 
	            WebElement sumField = driver.findElement(By.name("sum"));
	            int num1 = 10;
	            int num2 = 20;
	            int expectedSum = num1 + num2;
	            sumField.sendKeys(String.valueOf(expectedSum));

	            // Step 4: Submit the form
	            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
	            submitButton.click();

	            // Step 5: Verify successful submission message
	            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
	            String actualMessage = successMessage.getText();
	            String expectedMessage = "Form submitted successfully!";
	            if (actualMessage.equals(expectedMessage)) {
	                System.out.println("Form submitted successfully!");
	            } else {
	                System.out.println("Form submission failed. Actual message: " + actualMessage);
	            }

	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           // driver.quit();
	        }

	}

}
