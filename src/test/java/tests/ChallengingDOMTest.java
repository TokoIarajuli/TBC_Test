package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ChallengingDOMPage;

import java.util.Arrays;

@Epic("Challenging DOM Epic")
public class ChallengingDOMTest {

    WebDriver driver;
    private final static String driverPath = "C:\\selenium\\chromedriver_win32\\chromedriver.exe";
    private final static String URL = "http://the-internet.herokuapp.com";

    @Before
    @Description("Set up Chrome driver")
    public void setupChrome() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    @DisplayName("Challenging DOM test")
    @Description("User tries to confirm that every last character on elements in the first row is 0")
    public void ChallengingDOM() {
        ChallengingDOMPage page = new ChallengingDOMPage(driver);
        page.gotoPage();
        page.modifyValues();
    }

    @After
    public void close(){
        driver.close();
    }

}
