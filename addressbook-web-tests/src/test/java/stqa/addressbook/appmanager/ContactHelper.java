package stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stqa.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

    public ContactHelper (WebDriver wd) {
        super(wd);
    }

    public void fillUserCreationForm(ContactData contactData, boolean creation) {
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

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
       click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToContactCreationForm() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage(){
        wd.findElement(By.linkText("home"));
    }

    public void editContact(){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
    public void submitContactModification(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
    public void selectContact(){
        click(By.cssSelector("input[type='checkbox']"));
    }
    public void deleteContact(){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
    public void confirmContactDeletion(){
       alertAccept();
   }

   public void initContactCreation(){
        wd.findElement(By.linkText("add new")).click();
   }

   public void createContact(ContactData contact){
       initContactCreation();
       fillUserCreationForm(contact,true);
       submitContactCreation();
   }

   public boolean isThereAContact(){
        return isElementPresent(By.name("selected[]"));
   }

   }

