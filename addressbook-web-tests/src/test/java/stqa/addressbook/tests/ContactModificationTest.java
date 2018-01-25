package stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test (enabled = false)
    public void testContactModification () throws InterruptedException {

        app.goTo().gotoContactPage();
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
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),
                "UpdatedFirstName",
                "UpdatedMiddleName",
                "UpdatedLastName",
                "UpdatedNickName",
                "UpdatedCompanyName",
                "UpdatedAddress",
                "UpdatedMobilePhone",
                "UpdatedWork",
                "UpdatedEmployment",
                "UpdatedEmail",
                null);
        app.getContactHelper().fillUserCreationForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactCreationForm();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }
}
