// Name: Elisha Catherasoo
// Student Number: 101148507

package org.book;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String lastName);

}