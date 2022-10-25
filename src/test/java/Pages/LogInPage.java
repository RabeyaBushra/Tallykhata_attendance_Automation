package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class LogInPage {
    WebDriver driver;
    @FindBy(css = "input[name='login']")
    WebElement email;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement LoginBtn;
    @FindBy(xpath = "//i[@class='fa fa-th-large']")
     WebElement list;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    WebElement name;

    @FindBy(xpath = "//a[normalize-space()='Attendances']")
     WebElement attendanceBtn;

    @FindBy(xpath = "//a[@title='Sign in']")
     WebElement checkInBtn;

    @FindBy(xpath = "//a[@title='Sign out']")
    WebElement checkOutBtn;

    @FindBy(xpath = "//h3[@class='mt0 mb0 text-muted']")
     WebElement TextofCheckINorOut;


    @FindBy(xpath = "//h2[normalize-space()='Good evening']")
            WebElement GoodEvening;
    @FindBy(xpath = "//h2[normalize-space()='Have a good evening']")
                WebElement GoodDay;


    public LogInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String  doLogin(String Email,String password)
    {

        email.sendKeys(Email);
        Password.sendKeys(password);
        LoginBtn.click();
        return name.getText();

    }

    public void setAttendance() throws InterruptedException
    {
        list.click();
        Thread.sleep(2000);
        attendanceBtn.click();
    }


    public void Check() throws InterruptedException {
        String text=TextofCheckINorOut.getText();
        Thread.sleep(2000);
        System.out.println("after login  :" + text);
       if(text.contains("Click to check in"))
       {   Thread.sleep(2000);
           checkInBtn.click();
           //System.out.println("after click the checkin btn :" +  GoodEvening.getText());
           Thread.sleep(5000);

       }


       else
       {

           checkOutBtn.click();
           Thread.sleep(1000);
           System.out.println("after click the checkout btn :" + GoodDay.getText());
           checkInBtn.click();
           Thread.sleep(2000);
           System.out.println("after click the checkin btn :" +  GoodEvening.getText());
           Thread.sleep(2000);

       }


    }

}
