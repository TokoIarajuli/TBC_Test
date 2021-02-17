package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShiftingContentImagePage;
import pages.ShiftingContentPage;

@Epic("Shifting Content Epic")
public class ShiftingContentTest {

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
    @DisplayName("Shifting Content test")
    @Story("User checks hover and image move functionality")
    @Description("After hover, the color of element should be changed and after clicking the link image should move")
    public void ChallengingDOM() {
        ShiftingContentPage page = new ShiftingContentPage(driver);
        page.gotoPage();
        page.beforeHover();
        page.afterHover();
        page.checkColors();
        ShiftingContentImagePage imagePage = new ShiftingContentImagePage(driver);
        imagePage.gotoPage();
        imagePage.getCoordinatesBeforeClick();
        imagePage.getCoordinatesAfterClick();
        imagePage.compare();
    }


    @After
    public void close(){
        driver.close();
    }
}
