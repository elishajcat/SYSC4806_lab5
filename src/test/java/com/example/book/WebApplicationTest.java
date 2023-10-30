// Name: Elisha Catherasoo
// Student Number: 101148507

package com.example.book;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressBookRepository addressRepo;
    @Autowired
    private BuddyInfoRepository buddyRepo;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(content().string(containsString("")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void getAddressBooks() throws Exception {
        ArrayList<AddressBook> addressBooks = new ArrayList<>();
        addressRepo.findAll().forEach(addressBooks::add);
        this.mockMvc.perform(get("/addresses")).andDo(print()).andExpect(content()
                .string(containsString("[AddressBook[id = 1] {\n" +
                        "myBuddies = []\n" +
                        "}]")));
    }

    @Test
    public void addBook() throws Exception {
        AddressBook a1 = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("Harry", "Toronto", "6624523413");
        a1.addBuddy(b1);
        String body = asJsonString(a1);
        this.mockMvc.perform(post("/addresses")).andDo(print()).andExpect(content()
                .string(containsString("Address Books = [AddressBook[id = 1]")));
    }

    @Test
    public void addBuddies() throws Exception {
        AddressBook a1 = new AddressBook();
        a1.setId(1);
        BuddyInfo b1 = new BuddyInfo("Tom", "Carleton", "613");
        addressRepo.save(a1);
        buddyRepo.save(b1);
        this.mockMvc.perform(post("/addbud?id=1&buddy=b1")
                        .content(asJsonString(b1))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(content()
                        .string(containsString("")));
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @Test
//    public void getAllAddressBooks() throws Exception {
//        AddressBook a1 = new AddressBook();
//        BuddyInfo b1 = new BuddyInfo("Tom", "Carleton", "613");
//        a1.addBuddy(b1);
//        addressRepo.save(a1);
//        this.mockMvc.perform(get("/getadd")).andDo(print()).andExpect(content()
//                .string(containsString("myBuddies = [BuddyInfo[id=3, firstName=&#39;Tom&#39;, address=&#39;Carleton&#39;, phoneNumber=&#39;613&#39;]]")));
//    }
//
//    @Test
//    public void getBuddies() throws Exception {
//        AddressBook a1 = new AddressBook();
//        BuddyInfo b1 = new BuddyInfo("Jim", "Ottawa", "235134");
//        a1.addBuddy(b1);
//        addressRepo.save(a1);
//        this.mockMvc.perform(get("/getbud")).andDo(print()).andExpect(content()
//                .string(containsString("Buddies List = [BuddyInfo[id=1, firstName=&#39;Mike&#39;, address=&#39;Montreal&#39;, " +
//                        "phoneNumber=&#39;8729473432&#39;], BuddyInfo[id=2, firstName=&#39;Tom&#39;, address=&#39;Carleton&#39;, " +
//                        "phoneNumber=&#39;613&#39;], BuddyInfo[id=3, firstName=&#39;Tom&#39;, address=&#39;Carleton&#39;, " +
//                        "phoneNumber=&#39;613&#39;], BuddyInfo[id=4, firstName=&#39;Jim&#39;, address=&#39;Ottawa&#39;, phoneNumber=&#39;235134&#39;]]")));
//    }
//
//    @Test
//    public void addAddressBook() throws Exception {
//        AddressBook a1 = new AddressBook();
//        BuddyInfo b1 = new BuddyInfo("Harry", "Toronto", "6624523413");
//        a1.addBuddy(b1);
//        this.mockMvc.perform(post("/addadd")).andDo(print()).andExpect(content()
//                .string(containsString("Address Books = null")));
//    }
//
//    @Test
//    public void addBuddy() throws Exception {
//        AddressBook a1 = new AddressBook();
//        BuddyInfo b1 = new BuddyInfo("Mike", "Montreal", "8729473432");
//        addressRepo.save(a1);
//        this.mockMvc.perform(post("/addbud?id=1&name=Mike&address=Montreal&phoneNumber=8729473432")
//                        .content(asJsonString(b1))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print()).andExpect(content()
//                        .string(containsString("Address Books = [AddressBook[id = 1] {\n" +
//                                "myBuddies = [BuddyInfo[id=1, firstName=&#39;Mike&#39;, address=&#39;Montreal&#39;, phoneNumber=&#39;8729473432&#39;]]")));
//    }
//
//    @Test
//    public void deleteAddressBook() throws Exception {
//        AddressBook a1 = new AddressBook();
//        a1.setId(1);
//        BuddyInfo b1 = new BuddyInfo("Tom", "Carleton", "613");
//        addressRepo.save(a1);
//        buddyRepo.save(b1);
//        this.mockMvc.perform(delete("/deladd?addressId=1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print()).andExpect(content()
//                        .string(containsString("")));
//    }
//
//    @Test
//    public void deleteBuddy() throws Exception {
//        AddressBook a1 = new AddressBook();
//        a1.setId(1);
//        BuddyInfo b1 = new BuddyInfo("Tom", "Carleton", "613");
//        addressRepo.save(a1);
//        buddyRepo.save(b1);
//        this.mockMvc.perform(delete("/delbud?addressId=1&buddyId=1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print()).andExpect(content()
//                        .string(containsString("Address Books = null")));
//    }
}
