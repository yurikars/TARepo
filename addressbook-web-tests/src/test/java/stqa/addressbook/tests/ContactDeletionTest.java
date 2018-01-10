package stqa.addressbook.tests;

import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;

public class ContactDeletionTest  extends TestBase  {

    @Test
    public void testContactDeletion() throws InterruptedException {

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
        app.getContactHelper().returnToHomePage();
        Thread.sleep(3000);
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeletion();
    }

}
