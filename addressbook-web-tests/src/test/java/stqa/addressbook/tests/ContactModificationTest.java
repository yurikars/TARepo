package stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.addressbook.model.ContactData;
import stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactModificationTest extends TestBase {

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
    public void testContactModification (){
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next(); //Выбор первого попавшегося элемента множества
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).
                withLastName("test2").
                withMiddleName("test3").
                withMobilePhone("+375297770000").
                withAddress("SomeAddress").
                withCompanyName("Company Name").
                withEmail("SomeMail").
                withEmployment("SomeEmployment").
                withGroup("SomeGroup");

        app.contact().editContact(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
