package stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import stqa.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    private final GroupHelper groupHelper = new GroupHelper();

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        groupHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper.wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        groupHelper.wd.findElement(By.name("user")).click();
        groupHelper.wd.findElement(By.name("user")).clear();
        groupHelper.wd.findElement(By.name("user")).sendKeys(username);
        groupHelper.wd.findElement(By.name("pass")).click();
        groupHelper.wd.findElement(By.name("pass")).clear();
        groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
        groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void gotoGroupPage() {
        groupHelper.wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.wd.quit();
    }

    public void fillUserCreationForm(ContactData contactData) {
        groupHelper.wd.findElement(By.name("firstname")).click();
        groupHelper.wd.findElement(By.name("firstname")).clear();
        groupHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        groupHelper.wd.findElement(By.name("middlename")).click();
        groupHelper.wd.findElement(By.name("middlename")).clear();
        groupHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
        groupHelper.wd.findElement(By.name("lastname")).click();
        groupHelper.wd.findElement(By.name("lastname")).clear();
        groupHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        groupHelper.wd.findElement(By.name("nickname")).click();
        groupHelper.wd.findElement(By.name("nickname")).clear();
        groupHelper.wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
        groupHelper.wd.findElement(By.name("company")).click();
        groupHelper.wd.findElement(By.name("company")).clear();
        groupHelper.wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
        groupHelper.wd.findElement(By.name("address")).click();
        groupHelper.wd.findElement(By.name("address")).clear();
        groupHelper.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        groupHelper.wd.findElement(By.name("mobile")).click();
        groupHelper.wd.findElement(By.name("mobile")).clear();
        groupHelper.wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
        groupHelper.wd.findElement(By.name("work")).click();
        groupHelper.wd.findElement(By.name("work")).clear();
        groupHelper.wd.findElement(By.name("work")).sendKeys(contactData.getWork());
        groupHelper.wd.findElement(By.name("work")).click();
        groupHelper.wd.findElement(By.name("work")).clear();
        groupHelper.wd.findElement(By.name("work")).sendKeys(contactData.getEmployment());
        groupHelper.wd.findElement(By.name("email")).click();
        groupHelper.wd.findElement(By.name("email")).clear();
        groupHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());

    }

    public void submitUserCreation() {
        groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void gotoUserPage() {
        groupHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
