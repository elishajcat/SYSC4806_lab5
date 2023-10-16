// Name: Elisha Catherasoo
// Student Number: 101148507

package org.book;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AddressBook class
 */
@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<BuddyInfo> myBuddies;

    /**
     * Constructor for AddressBook
     */
    public AddressBook(){
        myBuddies = new ArrayList<>();
    }

    /**
     * Add a buddy to the address book
     * @param aBuddy BuddyInfo
     */
    public void addBuddy(BuddyInfo aBuddy){
        if (aBuddy != null) {
            myBuddies.add(aBuddy);
        }
    }

    /**
     * Remove buddy based on it's index
     * @param aBuddy BuddyInfo
     */
    public void removeBuddy(BuddyInfo aBuddy){
        this.myBuddies.remove(aBuddy);
    }

    /**
     * Gets the id of this Player. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of this Player to the specified value.
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the list of buddies
     * @return ArrayList<BuddyInfo>
     */
    public List<BuddyInfo> getBuddies() {
        return myBuddies;
    }

    @Override
    public String toString() {
        return "AddressBook[id = " + id + "] {\nmyBuddies = " + myBuddies.toString() + "\n}";
    }

    public static void main(String[] args){
        BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613");
        BuddyInfo buddy2 = new BuddyInfo("Homer", "Toronto", "747-098-4567");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        System.out.println(addressBook);
    }
}
