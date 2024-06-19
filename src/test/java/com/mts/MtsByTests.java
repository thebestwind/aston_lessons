package com.mts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MtsByTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mts.by/");
    }

    @Test
    public void testBlockTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение без комиссии')]")));
        Assert.assertEquals(blockTitle.getText(), "Онлайн пополнение без комиссии");
    }

    @Test
    public void testPaymentSystemsLogos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='payment-systems']//img")));
        Assert.assertFalse(logos.isEmpty(), "Payment systems logos are not displayed");

        for (WebElement logo : logos) {
            Assert.assertTrue(logo.isDisplayed(), "A payment system logo is not displayed");
        }
    }

    @Test
    public void testMoreInfoLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement closeCookieBanner = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cookie__wrapper .close")));
            closeCookieBanner.click(); // Закрыть баннер cookie
        } catch (Exception e) {
            // Если баннер отсутствует, продолжаем тест
        }

        WebElement moreInfoLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        moreInfoLink.click();

        // Ожидание загрузки новой страницы
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"), "URL does not contain the expected text");

        // Проверка наличия ожидаемого контента на новой странице
        WebElement expectedContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Порядок оплаты и безопасность интернет-платежей')]")));
        Assert.assertTrue(expectedContent.isDisplayed(), "Expected content is not displayed on the page");
    }

    @Test
    public void testPlaceholderTexts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Проверка для "Услуги связи"
        WebElement servicesDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("serviceType")));
        servicesDropdown.click();
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='УСЛУГИ СВЯЗИ']")));
        serviceOption.click();
        WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumber")));
        Assert.assertEquals(phoneNumberInput.getAttribute("placeholder"), "Введите номер телефона", "Placeholder text for phone number is incorrect");

        // Проверка для "Домашний интернет"
        servicesDropdown.click();
        serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='ДОМАШНИЙ ИНТЕРНЕТ']")));
        serviceOption.click();
        WebElement internetAccountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("internetAccount")));
        Assert.assertEquals(internetAccountInput.getAttribute("placeholder"), "Введите номер договора", "Placeholder text for internet account is incorrect");

        // Проверка для "Рассрочка"
        servicesDropdown.click();
        serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='РАССРОЧКА']")));
        serviceOption.click();
        WebElement installmentAccountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("installmentAccount")));
        Assert.assertEquals(installmentAccountInput.getAttribute("placeholder"), "Введите номер договора", "Placeholder text for installment account is incorrect");

        // Проверка для "Задолженность"
        servicesDropdown.click();
        serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='ЗАДОЛЖЕННОСТЬ']")));
        serviceOption.click();
        WebElement debtAccountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("debtAccount")));
        Assert.assertEquals(debtAccountInput.getAttribute("placeholder"), "Введите номер договора", "Placeholder text for debt account is incorrect");
    }

    @Test
    public void testContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement servicesDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("serviceType")));
        servicesDropdown.click();
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='УСЛУГИ СВЯЗИ']")));
        serviceOption.click();
        WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phoneNumber")));
        phoneNumberInput.sendKeys("297777777");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continueButton")));
        continueButton.click();

        // Проверка корректности отображения суммы, номера телефона, надписей в незаполненных полях и иконок платёжных систем
        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        Assert.assertTrue(amount.isDisplayed(), "Amount is not displayed");
        Assert.assertEquals(amount.getText(), "Expected amount text", "Amount text is incorrect");

        WebElement displayedPhoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayedPhoneNumber")));
        Assert.assertTrue(displayedPhoneNumber.isDisplayed(), "Phone number is not displayed");
        Assert.assertEquals(displayedPhoneNumber.getText(), "297777777", "Phone number text is incorrect");

        WebElement cardNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
        Assert.assertEquals(cardNumberInput.getAttribute("placeholder"), "Введите номер карты", "Placeholder text for card number is incorrect");

        WebElement expirationDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expirationDate")));
        Assert.assertEquals(expirationDateInput.getAttribute("placeholder"), "MM/YY", "Placeholder text for expiration date is incorrect");

        WebElement cvvInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvv")));
        Assert.assertEquals(cvvInput.getAttribute("placeholder"), "CVV", "Placeholder text for CVV is incorrect");

        List<WebElement> paymentSystemIcons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='payment-systems']//img")));
        Assert.assertFalse(paymentSystemIcons.isEmpty(), "Payment system icons are not displayed");

        for (WebElement icon : paymentSystemIcons) {
            Assert.assertTrue(icon.isDisplayed(), "A payment system icon is not displayed");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
