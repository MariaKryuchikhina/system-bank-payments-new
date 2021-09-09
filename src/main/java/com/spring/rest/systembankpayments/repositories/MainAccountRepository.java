package com.spring.rest.systembankpayments.repositories;

import com.spring.rest.systembankpayments.entity.MainAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;


public interface MainAccountRepository extends JpaRepository<MainAccount, Long> {

//    @Query("SELECT numberMain, amountMain, expirationDate FROM mainAccount WHERE idHistory in " +
//            "(SELECT type, name, transferDate, amount FROM replenishmentHistory) ")
//    MainAccount getAccountInformation(@PathVariable long id);
}
