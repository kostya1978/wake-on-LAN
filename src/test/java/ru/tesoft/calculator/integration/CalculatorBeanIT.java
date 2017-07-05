package ru.tesoft.calculator.integration;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.tesoft.util.Util;

import static org.junit.Assert.assertEquals;

/**
 * Created by Konstantin on 08.02.2016.
 */

public class CalculatorBeanIT {

    static Logger logger = Logger.getLogger(CalculatorBeanIT.class);
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", Util.getCurrentProjectPath() + "/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test2Plus3() {
        logger.debug("testAddition");

        // Open Calculator application in Chrome Browser:
        driver.get("http://localhost:8080/Calculator");

        // Find the "Button 2" element by it's id="btn2":
        WebElement knopka2 = driver.findElement(By.id("btn2"));
        // Click the "Button 2":
        knopka2.click();

        // Find the "Button +" element by it's id="btn+":
        WebElement knopkaPlus = driver.findElement(By.id("btn+"));
        knopkaPlus.click();

        // Find the "Button 3" element by it's id="btn3":
        WebElement knopka3 = driver.findElement(By.id("btn3"));
        knopka3.click();

        // Find the "Button =" element by it's id="btn=":
        WebElement knopkaRavno = driver.findElement(By.id("btn="));
        knopkaRavno.click();

        // Find the Input Text element by it's id="display":
        WebElement display = driver.findElement(By.id("display"));
        String displayText = display.getAttribute("value");

        try {
            // Compare expected and actual results:
            assertEquals("5", displayText);

            // Let the user actually see something:
            Thread.sleep(3500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close the browser
            driver.quit();
        }
    }

    @Test
    public void test2Times3() {
        logger.debug("testAddition");

        // Open Calculator application in Chrome Browser:
        driver.get("http://localhost:8080/Calculator");

        // Find the "Button 2" element by it's id="btn2":
        WebElement button2 = driver.findElement(By.id("btn2"));
        // Click the "Button 2":
        button2.click();

        // Find the "Button X" element by it's id="btn*":
        WebElement buttonX = driver.findElement(By.id("btn*"));
        buttonX.click();

        // Find the "Button 3" element by it's id="btn3":
        WebElement button3 = driver.findElement(By.id("btn3"));
        button3.click();

        // Find the "Button =" element by it's id="btn=":
        WebElement buttonEquals = driver.findElement(By.id("btn="));
        buttonEquals.click();

        // Find the Input Text element by it's id="display":
        WebElement display = driver.findElement(By.id("display"));
        String displayText = display.getAttribute("value");

        try {
            // Compare expected and actual results:
            assertEquals("6", displayText);

            // Let the user actually see something:
            Thread.sleep(3500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close the browser
            driver.quit();
        }
    }

    @Test
    public void test10Divide2() {
        logger.debug("testAddition");

        // Open Calculator application in Chrome Browser:
        driver.get("http://localhost:8080/Calculator");

        // Find the "Button 1" element by it's id="btn1":
        WebElement button1 = driver.findElement(By.id("btn1"));
        // Click the "Button 1":
        button1.click();

        // Find the "Button 0" element by it's id="btn0":
        WebElement button0 = driver.findElement(By.id("btn0"));
        button0.click();

        // Find the "Button divide" element by it's id="btn/":
        WebElement buttonDivide = driver.findElement(By.id("btn/"));
        buttonDivide.click();

        // Find the "Button 2" element by it's id="btn2":
        WebElement button2 = driver.findElement(By.id("btn2"));
        button2.click();

        // Find the "Button =" element by it's id="btn=":
        WebElement buttonEquals = driver.findElement(By.id("btn="));
        buttonEquals.click();

        // Find the Input Text element by it's id="display":
        WebElement display = driver.findElement(By.id("display"));
        String displayText = display.getAttribute("value");

        try {
            // Compare expected and actual results:
            assertEquals("5", displayText);

            // Let the user actually see something:
            Thread.sleep(3500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close the browser
            driver.quit();
        }
    }

    @Test
    public void test8Minus3() {
        logger.debug("testAddition");

        // Open Calculator application in Chrome Browser:
        driver.get("http://localhost:8080/Calculator");

        // Find the "Button 8" element by it's id="btn8":
        WebElement button8 = driver.findElement(By.id("btn8"));
        // Click the "Button 8":
        button8.click();

        // Find the "Button minus" element by it's id="btn-":
        WebElement buttonMinus = driver.findElement(By.id("btn-"));
        buttonMinus.click();

        // Find the "Button 3" element by it's id="btn3":
        WebElement button3 = driver.findElement(By.id("btn3"));
        button3.click();

        // Find the "Button =" element by it's id="btn=":
        WebElement buttonEquals = driver.findElement(By.id("btn="));
        buttonEquals.click();

        // Find the Input Text element by it's id="display":
        WebElement display = driver.findElement(By.id("display"));
        String displayText = display.getAttribute("value");

        try {
            // Compare expected and actual results:
            assertEquals("5", displayText);

            // Let the user actually see something:
            Thread.sleep(3500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close the browser
            driver.quit();
        }
    }


}
