package Krieger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestImplementation {
    WebDriver driver;
    Actions builder;

    public void initializeBrowser(String browserType){
        switch (browserType) {
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "IE" -> {
                WebDriverManager.iedriver().setup();
                driver = new ChromeDriver();
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        builder = new Actions(driver);
    }

    public void navigateToPage(String page){
        driver.navigate().to(page);
    }

    public void acceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver, 4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("consentForm__root")));

        WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"responsive\"]/div[16]/div/div/div[2]/div[2]/button"));
        acceptButton.click();
    }

    public void findNewsletterSection(){
        WebElement newsLetterSection = driver.findElement(By.className("footerNewsletter__form"));
        Assert.assertTrue(newsLetterSection.isDisplayed());
    }

    public void inputEmail(String email){
        WebElement inputSection = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        inputSection.click();
        inputSection.sendKeys(email);
    }

    public void clickOnButton(String buttonText){
        WebElement button = driver.findElement(By.xpath("//button[text()=\""+buttonText+"\"]"));
        button.click();
    }

    public void visibilityOfConfirmation(){
        WebDriverWait wait = new WebDriverWait(driver, 4000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("footerNewsletter__confirmation")));

        WebElement confirmationSection = driver.findElement(By.className("footerNewsletter__confirmation"));
        Assert.assertTrue(confirmationSection.isDisplayed());
    }

    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}
