// Name: Elisha Catherasoo
// Student Number: 101148507

package org.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AccessingDataJpaApplication {

//	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(AddressBookRepository repositoryAddressBook, BuddyInfoRepository repositoryBuddyInfo) {
//		return (args) -> {
//			// save a few buddyInfo
//			BuddyInfo buddy1 = new BuddyInfo("Tom", "Carleton", "613-135-1265");
//        	BuddyInfo buddy2 = new BuddyInfo("Homer", "Toronto", "747-098-4567");
//        	BuddyInfo buddy3 = new BuddyInfo("John", "Ottawa", "647-123-1234");
////			repositoryBuddyInfo.save(buddy1);
////			repositoryBuddyInfo.save(buddy2);
////			repositoryBuddyInfo.save(buddy3);
//
//			// save addressBook with the buddyInfo
//			AddressBook addressBook = new AddressBook();
////			repositoryAddressBook.save(addressBook);
//			addressBook.addBuddy(buddy1);
//			addressBook.addBuddy(buddy2);
//			addressBook.addBuddy(buddy3);
//			repositoryAddressBook.save(addressBook);
//
//			// fetch all address books
//			log.info("Address Book found with findAll():");
//			log.info("-------------------------------");
//			for (AddressBook addressBook1 : repositoryAddressBook.findAll()) {
//				log.info(addressBook1.toString());
//			}
//
//			// fetch an AddressBook by ID
//			Optional<AddressBook> addressBook1 = repositoryAddressBook.findById(1L);
//			log.info("Address Book found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(addressBook1.toString());
//			log.info("");
//
//			// fetch all buddyInfo
//			log.info("Buddy Info found with findAll():");
//			log.info("-------------------------------");
//			for (BuddyInfo buddyInfo : repositoryBuddyInfo.findAll()) {
//				log.info(buddyInfo.toString());
//			}
//			log.info("");
//
//			// fetch an individual buddyInfo by ID
//			Optional<BuddyInfo> buddyInfo = repositoryBuddyInfo.findById(1L);
//			log.info("buddyInfo found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(buddyInfo.toString());
//			log.info("");
//
//			// fetch buddyInfo by last name
//			log.info("buddyInfo found with findByName('John'):");
//			log.info("--------------------------------------------");
//			repositoryBuddyInfo.findByName("John").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//
//			log.info("");
//		};
//	}

}