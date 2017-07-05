package ru.tesoft.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

/**
 * Created by nikolaevk on 5/23/2017.
 */
public class Util {
  static Logger logger = Logger.getLogger(Util.class);

  public static String getCurrentProjectPath() {
    String myProjectPath = new File(".").getAbsolutePath().replaceAll(".$", "");

    if (myProjectPath.endsWith("/")) {
      myProjectPath = myProjectPath.substring(0, myProjectPath.length() - 1);
    }

    return myProjectPath;
  }

  /**
   * https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document
   *
   * "stale element reference: element is not attached to the page document" error.
   *
   * The reason for this is because the element to which you have referred is removed from the DOM structure
   *
   * I was facing the same problem while working with IEDriver. The reason was because javascript loaded the element one
   * more time after i have referred so my date reference pointed to an unexisting object even if it was
   * right their on UI. I used the following workaround.
   *
   * @param by
   * @param driver
   */
  public static void waitElementUntilPresent(By by, WebDriver driver) {
    boolean flag = true;
    while(flag) {
      try {
        Thread.sleep(1000);
        logger.debug("Slept for 1 sec");
        WebElement date = driver.findElement(by);
        date.getText();
        flag = false;
      } catch (InterruptedException e) {
        logger.debug("InterruptedException");
        logger.debug(e);
      }catch (NoSuchElementException e) {
        logger.debug("NoSuchElementException");
        logger.debug(e);
      } catch (org.openqa.selenium.StaleElementReferenceException e) {
        logger.debug("StaleElementReferenceException");
        logger.debug(e);
      }
    }
  }

  public static boolean isElementPresent(By by, WebDriver driver) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  public static void keepBrowserOpenFor3Seconds(){
    try {
      Thread.sleep(3500);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
