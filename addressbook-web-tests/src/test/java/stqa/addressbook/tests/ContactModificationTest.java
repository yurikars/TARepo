package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification () throws InterruptedException {

        app.getNavigationHelper().gotoContactPage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact((new ContactData(
                    "Name",
                    "MiddleName",
                    "LastName",
                    "nick",
                    "guglius",
                    "Bogota",
                    "+375297776655",
                    "noWork",
                    "freelance",
                    "some@mail.com",
                    "test1")));
        }
        Thread.sleep(3000);
        app.getContactHelper().editContact();
        app.getContactHelper().fillUserCreationForm(new ContactData(
                        "UpdatedFirstName",
                        "UpdatedMiddleName",
                        "UpdatedLastName",
                        "UpdatedNickName",
                        "UpdatedCompannyName",
                        "UpdatedAddress",
                        "UpdatedMobilePhone",
                        "UpdatedWork",
                        "UpdatedEmployment",
                        "UpdatedEmail",
                        null),
                        false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactCreationForm();

    }
}
