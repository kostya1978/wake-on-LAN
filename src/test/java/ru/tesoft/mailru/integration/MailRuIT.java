package ru.tesoft.mailru.integration;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.tesoft.util.Util;

import static org.junit.Assert.assertEquals;

/**
 */

public class MailRuIT {

    static Logger logger = Logger.getLogger(MailRuIT.class);
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", Util.getCurrentProjectPath() + "/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        logger.debug("testLogin");

        // Open mail.ru application in Chrome Browser:
        driver.get("http://mail.ru");

        // Find the "loginTextBox" element by it's id="mailbox__login":
        WebElement loginTextBox = driver.findElement(By.id("mailbox__login"));
        loginTextBox.sendKeys("selenium.webdriver");

        // Find the "passwordTextBox" element by it's id="mailbox__password":
        WebElement passwordTextBox = driver.findElement(By.id("mailbox__password"));
        passwordTextBox.sendKeys("Gaspu3aQ");

        // Find the "enterButton" element by it's id="mailbox__auth__button":
        WebElement enterButton = driver.findElement(By.id("mailbox__auth__button"));

        // Click the "enterButton":
        enterButton.click();

        // Find the "userEmail" element by it's id="PH_user-email":
        // To avoid stale element reference error, we need to wait until element is loaded first:
        Util.waitElementUntilPresent(By.id("PH_user-email"), driver);
        WebElement userEmail = driver.findElement(By.id("PH_user-email"));
        String displayText = userEmail.getText();

        // Compare expected and actual results:
        assertEquals("selenium.webdriver@mail.ru", displayText);

        // Let the user actually see something:
        Util.keepBrowserOpenFor3Seconds();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
