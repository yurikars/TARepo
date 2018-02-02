package stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;
import stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest  extends TestBase  {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactsListPage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().
                    withFirstName("test1").
                    withLastName("test2").
                    withMiddleName("test3").
                    withMobilePhone("+375297770000").
                    withAddress("SomeAddress").
                    withCompanyName("Company Name").
                    withEmail("SomeMail").
                    withEmployment("SomeEmployment").
                    withGroup("SomeGroup"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next(); //Выбор первого попавшегося элемента множества
        app.contact().deleteContact(deletedContact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
