package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import com.google.common.base.Verify;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test Case: testCase01");

        // Type "calculator" in the Google search bar and press Enter
        WebElement googleSearchBar = driver.findElement(By.cssSelector("textarea[title='Search']"));
        googleSearchBar.sendKeys("calculator");
        googleSearchBar.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // Verify that the Google Calculator loads
        String url = driver.getCurrentUrl();
        String text = driver.findElement(By.cssSelector("div.card-section h2")).getText();
        if (url.contains("google") && text.contains("Calculator")) {
            System.out.println("Calculator loads successfully");
        } else {
            System.out.println("Failed to load calculator");
        }

        // Confirm that the initial display shows zero(0)
        int initialVal = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (initialVal == 0) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        System.out.println("End Test Case: testCase01");
    }

    public void testCase02() {
        System.out.println("Start Test Case: testCase02");

        // Perform an addition operation, 5 + 7 and confirm that the displayed result is
        // correct (in this case, 12)
        WebElement five = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(3) td:nth-child(2) div[role='button']"));
        five.click();
        WebElement add = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(4) div[role='button']"));
        add.click();
        WebElement seven = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(2) td:nth-child(1) div[role='button']"));
        seven.click();
        WebElement calculate = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(3) div[role='button']"));
        calculate.click();
        int additionResult = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (additionResult == 12) {
            System.out.println("Addition Successful");
        } else {
            System.out.println("Addition Failed");
        }

        // Perform a subtraction operation, 15 - 8 and confirm that the displayed result
        // is correct (in this case, 7)
        WebElement one = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(4) td:nth-child(1) div[role='button']"));
        one.click();
        five.click();
        WebElement subtract = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(4) td:nth-child(4) div[role='button']"));
        subtract.click();
        WebElement eight = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(2) td:nth-child(2) div[role='button']"));
        eight.click();
        calculate.click();
        int subtractionResult = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (subtractionResult == 7) {
            System.out.println("Subtraction Successful");
        } else {
            System.out.println("Subtraction Failed");
        }

        System.out.println("End Test Case: testCase02");
    }

    public void testCase03() {
        System.out.println("Start Test Case: testCase03");

        // Perform a multiplication operation, 10 * 3 and confirm that the displayed
        // result is correct (in this case, 30)
        WebElement one = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(4) td:nth-child(1) div[role='button']"));
        one.click();
        WebElement zero = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(1) div[role='button']"));
        zero.click();
        WebElement multiply = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(3) td:nth-child(4) div[role='button']"));
        multiply.click();
        WebElement three = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(4) td:nth-child(3) div[role='button']"));
        three.click();
        WebElement calculate = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(3) div[role='button']"));
        calculate.click();
        int multiplicationResult = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (multiplicationResult == 30) {
            System.out.println("Multiplication Successful");
        } else {
            System.out.println("Multiplication Failed");
        }

        // Click the "AC" (All Clear) button on the calculator and verify that the
        // display clears
        WebElement acElement = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(1) td:nth-child(4) div[role='button']"));
        acElement.click();
        int initialVal = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (initialVal == 0) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        System.out.println("End Test Case: testCase03");
    }

    public void testCase04() {
        System.out.println("Start Test Case: testCase04");

        // Perform a division operation, 20 / 4 and confirm that the displayed result is
        // correct (in this case, 5)
        WebElement two = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(4) td:nth-child(2) div[role='button']"));
        two.click();
        WebElement zero = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(1) div[role='button']"));
        zero.click();
        WebElement divide = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(2) td:nth-child(4) div[role='button']"));
        divide.click();
        WebElement four = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(3) td:nth-child(1) div[role='button']"));
        four.click();
        WebElement calculate = driver
                .findElement(By.cssSelector("table.ElumCf tr:nth-child(5) td:nth-child(3) div[role='button']"));
        calculate.click();
        int divisionResult = Integer.parseInt(driver.findElement(By.cssSelector("#cwos")).getText());
        if (divisionResult == 5) {
            System.out.println("Division Successful");
        } else {
            System.out.println("Division Failed");
        }

        System.out.println("End Test Case: testCase04");
    }

}
