// Name: Elisha Catherasoo
// Student Number: 101148507

import org.book.AddressBook;
import org.book.BuddyInfo;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for Address Book
 */
@SpringBootTest
public class AddressBookTest {

//    @Autowired
//    AddressBookRepository repo;

    /**
     * Test adding a buddy to the address book
     */
    @Test
    public void testAddBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
        BuddyInfo buddy2 = new BuddyInfo();
        addressBook.addBuddy(buddy1);
        Assert.assertEquals(1, addressBook.getBuddies().size());

        addressBook.addBuddy(buddy2);
        Assert.assertEquals(2, addressBook.getBuddies().size());
        Assert.assertEquals(buddy2.getAddress(), addressBook.getBuddies().get(1).getAddress());
        Assert.assertEquals(buddy2.getName(), addressBook.getBuddies().get(1).getName());
        Assert.assertEquals(buddy2.getPhoneNumber(), addressBook.getBuddies().get(1).getPhoneNumber());
    }

    /**
     * Test removing a buddy to the address book
     */
    @Test
    public void testRemoveBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
        BuddyInfo buddy2 = new BuddyInfo();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        Assert.assertEquals(2, addressBook.getBuddies().size());

        addressBook.removeBuddy(buddy1);
        Assert.assertEquals(1, addressBook.getBuddies().size());
    }
}
