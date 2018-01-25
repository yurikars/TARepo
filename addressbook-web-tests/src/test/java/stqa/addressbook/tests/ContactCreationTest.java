package stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test (enabled = false)
    public void testContactCreation () {

        app.goTo().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("firstName",
                                              null,
                                              "lastName",
                                              null,
                                              null,
                                              "listTest",
                                              null,
                                              null,
                                              null,
                                              null,
                                              null);

        app.getContactHelper().fillUserCreationForm(contact,true);
        app.getContactHelper().submitContactCreation();
        app.goTo().gotoContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}
