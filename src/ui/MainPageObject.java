package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Метод ожидания
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(error_message + "\n");
        return  wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    //Ожидание элемента с кликом по нему
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return  element;

    }
    //Ввод текста
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return  element;

    }
}
