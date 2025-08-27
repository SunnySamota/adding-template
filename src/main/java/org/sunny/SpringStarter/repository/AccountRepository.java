package org.sunny.SpringStarter.repository;

import org.springframework.stereotype.Repository;
import org.sunny.SpringStarter.models.Account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    Optional<Account> findOneByEmailIgnoreCase(String username);
    
}

// package org.sunny.SpringStarter.repository;

// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;
// import org.sunny.SpringStarter.models.Account;

// @Repository
// public interface AccountRepository extends JpaRepository<Account, Long> {

//     // Fetch account + authorities in one query to avoid LazyInitializationException
//     @Query("SELECT a FROM Account a LEFT JOIN FETCH a.authorities WHERE LOWER(a.email) = LOWER(:email)")
//     Optional<Account> findOneByEmailIgnoreCase(@Param("email") String email);
// }
