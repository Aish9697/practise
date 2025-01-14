package Jan31;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        // WebDriver initialization
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Open the application
        driver.get("http://3.109.127.119:3000/");
        Thread.sleep(1000);

        // Login process
        driver.findElement(By.id("username")).sendKeys("john@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Alphaware@123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);

        // Navigating to the required page
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/a[1]/*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[4]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();

        // Generate random names and Aadhar number
        String firstName = generateFirstName();
        String middleName = generateMiddleName();
        String lastName = generateLastName();
        String aadharNumber = generateAadharNumber();

        // Filling form fields with generated data
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("middleName")).sendKeys(middleName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("agentUserName")).sendKeys("Aish");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/form[10]/div/div/div/table/tbody/tr[1]/td[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/form[11]/div/div/div[2]/input")).click();
        driver.findElement(By.name("aadharNumber")).sendKeys(aadharNumber);
        WebElement dateInput = driver.findElement(By.name("birthDate"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = '';", dateInput);
        dateInput.sendKeys("11-11-2000");
        Thread.sleep(5000);

        // Wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][1]")));

        // Scroll to the button to make it visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Attempt to click using JavaScript if normal click fails
        try {
            submitButton.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click if intercepted
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        }
        System.out.println("Congrats!!! Customer created successfully.");
        Thread.sleep(3000);

        //Address
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("line1")).sendKeys("Powai LakeHights", Keys.TAB);
        driver.findElement(By.name("houseNumber")).sendKeys("11", Keys.TAB);
        driver.findElement(By.name("buildingName")).sendKeys("TCG", Keys.TAB);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[1]/form[5]/div/div/div[1]/div[2]")).click();
        driver.findElement(By.xpath("//div[@class='css-qr46ko']//div[text()='INDIA']")).click();
        Thread.sleep(3000);
       WebElement state= driver.findElement(By.xpath(".//div[@class='css-hlgwow']"));
       state.click();
        driver.findElement(By.xpath(".//div[@class='css-qr46ko']//div[@role='option'][16]")).click();
        driver.switchTo().defaultContent();
		
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[1]/form[7]/div/div/div[1]/div[2]")).click();
        driver.findElement(By.xpath("//div[@class='css-qr46ko']//div[text()='MUMBAI']")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[1]/form[8]/div/div/div[1]/div[2]")).click();
        driver.findElement(By.xpath(".//div[@role='listbox']//div[text()='MUMBAI CITY']")).click();
        driver.findElement(By.xpath(".//input[@placeholder='Enter City']")).sendKeys("SAMBHAJINAGAR");
        driver.findElement(By.xpath(".//input[@placeholder='Enter Zip Code']")).sendKeys("431712");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[1]/form[12]/div/button")).click();
        System.out.println("ADDRESS CREATED SUCCESSFULLY !!");

    }  
        
        
        
           
        
     /*   Thread.sleep(5000);
        // Navigate to Nominee Section
        WebElement nomineeTab = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/ul/li[2]"));
        // Scroll to the Nominee tab
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nomineeTab);
        // Wait for the tab to be clickable and click
        wait.until(ExpectedConditions.elementToBeClickable(nomineeTab));

        try {
            nomineeTab.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click if intercepted
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nomineeTab);
        }

        // Re-locate the nomineeName field to avoid StaleElementReferenceException
        WebElement nomineeNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("nomineeName")));
        Thread.sleep(5000);

        // Ensure the element is interactable before sending keys
        try {
            nomineeNameField.sendKeys("Nidhi");
        } catch (StaleElementReferenceException e) {
            // Re-locate the element if it becomes stale
            nomineeNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("nomineeName")));
            nomineeNameField.sendKeys("Nidhi");
        }
        Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]/form[2]/div")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("//div[@role='listbox']//div[@role='option'][1]")).click();
      Thread.sleep(5000);


       // driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]/form[2]/div/div/div[1]/div[1]")).click();
        
        WebElement nomineedob = driver.findElement(By.name("nomineeBirthDate"));
        jsExecutor.executeScript("arguments[0].value = '';", nomineedob);
        nomineedob.sendKeys("11-11-2000");
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]/form[7]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[1]/form[7]/div/button")).click();
        // Closing the browser
        // driver.quit();
    }
*/
    // Method to generate 12-digit Aadhar number that doesn't start with 0 or 1
    public static String generateAadharNumber() {
        Random random = new Random();
        StringBuilder aadhar = new StringBuilder();

        // Ensure the first digit is between 2 and 9
        int firstDigit = random.nextInt(8) + 2;  // Generates a number between 2 and 9
        aadhar.append(firstDigit);

        // Generate the remaining 11 digits (can be 0-9)
        for (int i = 0; i < 11; i++) {
            int digit = random.nextInt(10);  // Generates a number between 0-9
            aadhar.append(digit);
        }

        return aadhar.toString();
    }

    // Method to generate a random first name from an array of Indian names
    public static String generateFirstName() {
        String[] firstNames = {"Amit", "Rahul", "Sneha", "Priya", "Raj", "Suresh", "Sunita", "Aishwarya", "Vikas", "Anjali"};
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }

    // Method to generate a random middle name from an array of Indian names
    public static String generateMiddleName() {
        String[] middleNames = {"Kumar", "Singh", "Devi", "Chandra", "Patel", "Gupta", "Rao", "Sharma", "Verma", "Mehta"};
        Random random = new Random();
        return middleNames[random.nextInt(middleNames.length)];
    }

    // Method to generate a random last name from an array of Indian names
    public static String generateLastName() {
        String[] lastNames = {"Sharma", "Verma", "Gupta", "Patel", "Singh", "Reddy", "Nair", "Choudhary", "Rao", "Joshi"};
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }
}
