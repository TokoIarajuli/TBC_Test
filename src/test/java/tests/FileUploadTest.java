package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import pages.FileUploadPage;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Epic("File Upload Epic")
public class FileUploadTest {

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
    @DisplayName("File upload test")
    @Story("User tries to upload file")
    @Description("File upload functionality should be tested and confirmed")
    public void FileUpload() {
       FileUploadPage page = new FileUploadPage(driver);
       page.gotoPage();
       page.uploadFile();
       page.checkUpload();
       page.handleUpload();
    }

    @After
    public void close(){
        driver.close();
    }

}

