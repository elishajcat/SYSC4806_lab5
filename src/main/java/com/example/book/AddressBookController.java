// Name: Elisha Catherasoo
// Student Number: 101148507

package com.example.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AddressBookController {

    AddressBookRepository addressBookRepo;
    BuddyInfoRepository buddyInfoRepo;

    public AddressBookController(AddressBookRepository addressBookRepo, BuddyInfoRepository buddyInfoRepo) {
        this.addressBookRepo = addressBookRepo;
        this.buddyInfoRepo = buddyInfoRepo;
    }

    @GetMapping("/addresses")
    public String getAddresses(Model model){
        ArrayList<AddressBook> addressBooks = new ArrayList<>();
        addressBookRepo.findAll().forEach(addressBooks::add);
        model.addAttribute("AddressBooks", addressBooks);
        model.addAttribute("BuddyInfos", new BuddyInfo());

        return "main";
    }

    @PostMapping("/addresses")
    public String addAddressBook(Model model){
        AddressBook a = new AddressBook();
        addressBookRepo.save(a);
        ArrayList<AddressBook> addressBooks = new ArrayList<>();
        addressBookRepo.findAll().forEach(addressBooks::add);
        model.addAttribute("AddressBooks", addressBooks);
        model.addAttribute("BuddyInfos", new BuddyInfo());

        return "main";
    }

    @PostMapping("/addresses/{id}/buddy")
    public String addBuddy(@PathVariable Long id, @ModelAttribute BuddyInfo buddy, Model model){
        Optional<AddressBook> a = addressBookRepo.findById(id);
        if(a.isEmpty()) return null;
        AddressBook a1 = a.get();
        a1.addBuddy(buddy);
        addressBookRepo.save(a1);

        model.addAttribute("BuddyInfos", buddy);

        return "redirect:/addresses";
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @GetMapping("/getadd")
//    public String getAddresses2(Model model){
//        model.addAttribute("Addresses", addressBookRepo.findAll().toString());
//        return "addresses";
//    }
//
//    @GetMapping("/getbud")
//    public String getBuddies(Model model){
//        model.addAttribute("Addresses", buddyInfoRepo.findAll());
//        return "buddies";
//    }
//
//    @PostMapping("/addadd")
//    public String addAddressBooks(Model model){
//        AddressBook a = new AddressBook();
//        addressBookRepo.save(a);
//        model.addAttribute("AddressId", a.getId());
//        return "addresses";
//    }
//
//    @PostMapping("/addbud")
//    public String addBuddy(@RequestParam Long id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber, Model model){
//        Optional<AddressBook> a = addressBookRepo.findById(id);
//        if(a.isEmpty()) return null;
//        AddressBook a1 = a.get();
//        a1.addBuddy(new BuddyInfo(name, address, phoneNumber));
//        addressBookRepo.save(a1);
//        model.addAttribute("Addresses", addressBookRepo.findAll());
//        return "addresses";
//    }
//
//    @DeleteMapping("/deladd")
//    public String removeAddress(@RequestParam Long id){
//        Optional<AddressBook> a1 = addressBookRepo.findById(id);
//        if(a1.isEmpty())return null;
//        addressBookRepo.deleteById(id);
//        return "addresses";
//    }
//
//    @DeleteMapping("/delbud")
//    public String removeBuddy(@RequestParam Long addressId, @RequestParam Long buddyId){
//        Optional<AddressBook> a1 = addressBookRepo.findById(addressId);
//        if(a1.isEmpty()) return null;
//        AddressBook a = a1.get();
//        Optional<BuddyInfo> b = buddyInfoRepo.findById(buddyId);
//        if(b.isEmpty()) return null;
//        a.removeBuddy(b.get());
//        addressBookRepo.save(a);
//        return "addresses";
//    }
}
