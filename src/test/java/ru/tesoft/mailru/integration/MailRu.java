package ru.tesoft.mailru.integration;

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
 */

public class MailRu {

  static Logger logger = Logger.getLogger(MailRu.class);
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", Util.getCurrentProjectPath() + "/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testLoginToMailRu() {
    logger.debug("testLoginToMailRu");





    try {
      // Compare expected and actual results:
      assertEquals("selenium.webdriver@mail.ru", "");

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
