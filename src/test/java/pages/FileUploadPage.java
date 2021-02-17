package pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileUploadPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "file-upload")
    private WebElement uploadElement;

    @FindBy(how = How.LINK_TEXT, using = "File Upload")
    private WebElement correctPage;

    @FindBy(how = How.TAG_NAME, using = "h3")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"file-submit\"]")
    private WebElement submitButton;


    public FileUploadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotoPage() {
        correctPage.click();
    }

    public void uploadFile() {
        uploadElement.sendKeys("C:\\Users\\user\\Desktop\\pic.jpg");
        submitButton.click();
    }

    public void checkUpload() {
        System.out.println(message.getText());
        assertThat(message.getText(), is("File Uploaded!"));
    }

    public void handleUpload() {
        if (!message.getText().equals("File Uploaded!"))
            throw new InvalidArgumentException("Couldn't upload file");
    }
}
