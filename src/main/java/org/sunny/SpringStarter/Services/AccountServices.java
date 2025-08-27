package org.sunny.SpringStarter.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sunny.SpringStarter.models.Account;
import org.sunny.SpringStarter.models.Authority;

import org.sunny.SpringStarter.repository.AccountRepository;
import org.sunny.SpringStarter.util.constants.Roles;
@Service
public class AccountServices implements UserDetailsService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        if(account.getRole()==null){
        account.setRole(Roles.USER.getRole());
        }
        return accountRepository.save(account);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
       Optional<Account> optionalAccount = accountRepository.findOneByEmailIgnoreCase(email);
       if(!optionalAccount.isPresent()){
        throw new UsernameNotFoundException("Account not found");
       }
       Account account =optionalAccount.get();
   List<GrantedAuthority> grantedAuthority= new ArrayList<>();
   grantedAuthority.add(new SimpleGrantedAuthority(account.getRole()));

       for(Authority _auth: account.getAuthorities()){
        grantedAuthority.add(new SimpleGrantedAuthority(_auth.getName()));
       }

       return new User(account.getEmail(), account.getPassword(), grantedAuthority);
    }
}
