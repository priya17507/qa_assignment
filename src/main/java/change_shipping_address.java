import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class change_shipping_address {

    public static void main(String[] args) throws InterruptedException {



        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.amazon.in/");
        Thread.sleep(8000);
        // Maximize the browser window
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();

        //sign-in page -> number/email field
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7282071972");

        //hit continue
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        //password field on next page
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("babli@5050");

        //hit sign-in button
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();



        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Reynolds ROLLER POINT Pen R7 1 CT BL- BLUE | Stylish Metal Clip Premium Look Rollerball Point Pen for Men");
        //searchBox.submit();
        searchBox.sendKeys(Keys.ENTER);

        // Find and click on the first item to add to the cart
        WebElement firstItem = driver.findElement(By.xpath("//img[@class='s-image']"));
        firstItem.click();

        // Wait for the page to load after clicking on the item
        // (You may need to use explicit or implicit waits here)


        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Iterate through the window handles
        for (String windowHandle : allWindowHandles) {
            // Check if it's the new window by comparing with the main window handle
            if (!windowHandle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                break; // Exit the loop after switching
            }
        }


        // Find and click on the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCartButton.click();

        // Wait for the cart to update after adding the item
        // (You may need to use explicit or implicit waits here) I am using thread.sleep() which is a kind of static wait in java

        // Navigate to the cart page
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=nav_cart");
        // here amazon ask for the login credentials, use no= 7282071972 password= babli@5050

        //proceed to checkout on cart page
        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();





        Thread.sleep(5000);
        //add new address
        driver.findElement(By.xpath("//a[@id='add-new-address-popover-link']")).click();


        //field address in popup
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("PRIYA DEVI");

        //Field address in popup
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("7282071972");

        //fill posal code
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("110002");


        //flat details - address-ui-widgets-enterAddressLine1
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("PG blue sea greenwood city");


        //more area details - address-ui-widgets-enterAddressLine2
        driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Block Asec 45 Sushant Lok Phase 1, Sector 43");
        Thread.sleep(5000);

        //Enter city
        //driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']")).sendKeys("");

        // hit use this address
        driver.findElement(By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")).click();
        Thread.sleep(5000);





        driver.quit();




    }
}
