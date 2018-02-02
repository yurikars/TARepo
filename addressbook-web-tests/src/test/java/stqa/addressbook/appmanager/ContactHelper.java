package stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stqa.addressbook.model.ContactData;
import stqa.addressbook.model.Contacts;
import stqa.addressbook.model.GroupData;
import stqa.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;
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

    public void editContact(ContactData contact){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
    public void submitContactModification(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
    public void selectContact(int index){
        click(By.cssSelector("input[type='checkbox']"));
    }
    public void deleteContact(ContactData contact){
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

//   public List<ContactData> getContactList(){
//        List<ContactData> contacts = new ArrayList<ContactData>();
//        List<WebElement> elements = wd.findElements(By.className("entry"));
//        for (WebElement element : elements){
//            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
//            String firstName = element.findElement(By.xpath(".//td[2]")).getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            ContactData contact = new ContactData(id, lastName,
//                                                   firstName,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null,
//                                                  null );
//            contacts.add(contact);
//        }
//        return contacts;
//   }

    private Contacts contactCashe = null;

//    public Contacts all(){
//
//        if (contactCashe != null){
//            return new Contacts(contactCashe);
//        }
//        contactCashe = new Contacts();
//
//        List<WebElement> elements = wd.findElements(By.className("entry"));
//        for (WebElement element : elements){
//            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
//            String firstName = element.findElement(By.xpath(".//td[2]")).getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//            ContactData contact = new ContactData(id, lastName,
//                    firstName,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null,
//                    null );
//            contacts.add(contact);
//        }
//        return contacts;
//    }
    public Contacts all() {

        if (contactCashe != null){
            return new Contacts(contactCashe);
        }
        contactCashe = new Contacts();

        // Функция для работы с множеством элементов
        Contacts contacts = new Contacts(); //Создаём объект для работы с множеством элементов
        List<WebElement> rows = wd.findElements(By.name("entry")); //Находим все элементы типа "Контакты" на странице (По записям)
        for (WebElement row :  rows) { //В цикле перебираем все элементы полученного списка
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value")); //Получаем id каждого контакта
            String lastname = cells.get(1).getText(); // Считывание фамилии
            String firstname = cells.get(2).getText(); //Считывание имени
            String allPhones = cells.get(5).getText(); //Разрезание строки на несколько частей и записыванием результата в переменную allPhones
            String allEmails = cells.get(4).getText();
            String address = cells.get(3).getText();
            contacts.add(new ContactData().
                    withId(id).
                    withFirstName(firstname).
                    withLastName(lastname).
                    withAddress(address).
                    withEmail(allEmails).
                    withMobilePhone(allPhones)); //Добавляем объект (Каждый считанный контакт) в список
        }
        return contacts;
    }
   }

