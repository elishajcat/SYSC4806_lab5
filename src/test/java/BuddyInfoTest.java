// Name: Elisha Catherasoo
// Student Number: 101148507

import org.book.BuddyInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for BuddyInfo
 *
 * testing the getters and setters
 */
public class BuddyInfoTest {
    BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");

//    @Autowired
//    BuddyInfoRepository repo;

    @Test
    public void setBuddyNameTest() {
        Assert.assertEquals("Tom", buddy.getName());

        buddy.setName("Tommy");
        Assert.assertEquals("Tommy", buddy.getName());
    }

    @Test
    public void setBuddyAddressTest() {
        Assert.assertEquals("Carleton", buddy.getAddress());

        buddy.setAddress("Nepean");
        Assert.assertEquals("Nepean", buddy.getAddress());
    }

    @Test
    public void setBuddyPhoneNumberTest() {
        Assert.assertEquals("613", buddy.getPhoneNumber());

        buddy.setPhoneNumber("647-231-1111");
        Assert.assertEquals("647-231-1111", buddy.getPhoneNumber());
    }
}
