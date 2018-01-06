package stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import stqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper (FirefoxDriver wd) {
        super(wd);
    }

    public void fillUserCreationForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getMiddleName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("nickname"),contactData.getNickName());
        type(By.name("company"),contactData.getCompanyName());
        type(By.name("address"),contactData.getAddress());
        type(By.name("mobile"),contactData.getMobilePhone());
        type(By.name("work"),contactData.getWork());
        type(By.name("work"),contactData.getEmployment());
        type(By.name("email"),contactData.getEmail());

    }

    public void submitUserCreation() {
       click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void gotoUserPage() {
        click(By.linkText("add new"));
    }
}
