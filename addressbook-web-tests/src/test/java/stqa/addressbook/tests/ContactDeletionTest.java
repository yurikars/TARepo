package stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest  extends TestBase  {

    @Test (enabled = false)
    public void testContactDeletion() throws InterruptedException {

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
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeletion();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);

//        Thread.sleep(3000);
//        app.getContactHelper().selectContact();
//        app.getContactHelper().deleteContact();
//        app.getContactHelper().confirmContactDeletion();
    }

}
