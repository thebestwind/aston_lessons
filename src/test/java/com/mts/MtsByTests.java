package com.mts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MtsByTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");  // Добавьте этот аргумент для запуска в режиме без графического интерфейса
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mts.by/");
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]"));
        Assert.assertEquals(blockTitle.getText(), "Онлайн пополнение без комиссии");
    }

    @Test
    public void testPaymentSystemsLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='payment-systems']//img"));
        Assert.assertTrue(logos.size() > 0, "Payment systems logos are not displayed");
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("service-info"), "The 'Подробнее о сервисе' link does not work correctly");
    }

    @Test
    public void testContinueButton() {
        WebElement servicesDropdown = driver.findElement(By.id("serviceType"));
        servicesDropdown.click();
        WebElement serviceOption = driver.findElement(By.xpath("//option[@value='УСЛУГИ СВЯЗИ']"));
        serviceOption.click();
        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumber"));
        phoneNumberInput.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.id("continueButton"));
        continueButton.click();
        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "The continue button does not work correctly");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
