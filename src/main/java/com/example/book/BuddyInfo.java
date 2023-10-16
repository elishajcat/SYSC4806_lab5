// Name: Elisha Catherasoo
// Student Number: 101148507

package com.example.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Buddyinfo class
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private int id;

    private String name = null;
    private String address = null;
    private String phoneNumber = null;

    /**
     * Constructor for BuddyInfo
     * @param name String
     * @param address String
     * @param phoneNumber String
     */
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Constructor for BuddyInfo with default values
     */
    public BuddyInfo() {
    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[id=%d, firstName='%s', address='%s', phoneNumber='%s']",
                id, name, address, phoneNumber);
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}