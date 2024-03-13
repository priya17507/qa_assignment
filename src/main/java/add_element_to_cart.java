import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class add_element_to_cart {

    public static void main(String[] args) throws InterruptedException {



        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "/Users/priyakumari/Downloads/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        // Maximize the browser window
        driver.manage().window().maximize();



        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Reynolds ROLLER POINT Pen R7 1 CT BL- BLUE ");
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



        Thread.sleep(3000);


        driver.quit();




    }
}
