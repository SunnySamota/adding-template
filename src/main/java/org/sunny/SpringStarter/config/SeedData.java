package org.sunny.SpringStarter.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.sunny.SpringStarter.Services.AccountServices;
import org.sunny.SpringStarter.Services.AuthorityService;
import org.sunny.SpringStarter.Services.PostService;
import org.sunny.SpringStarter.models.Account;
import org.sunny.SpringStarter.models.Authority;
import org.sunny.SpringStarter.models.Post;
import org.sunny.SpringStarter.repository.AuthorityRepository;
import org.sunny.SpringStarter.util.constants.Privilages;
import org.sunny.SpringStarter.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;

    private final PostService postService;
    private final AccountServices accountService;
    private final AuthorityService authorityService;

    @Autowired
    public SeedData(AuthorityRepository authorityRepository,
                    PostService postService,
                    AccountServices accountService,
                    AuthorityService authorityService) {
        this.authorityRepository = authorityRepository;
        this.postService = postService;
        this.accountService = accountService;
        this.authorityService = authorityService;
    }

    @Override
    public void run(String... args) throws Exception {

        // seed privileges into Authority table
        for (Privilages auth : Privilages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivilage());
            authorityService.save(authority);
        }

        // Accounts
        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("account01@sunny.org");
        account01.setPassword("password01");
        account01.setFirstname("user01");
        account01.setLastname("deepak");
        account01.setRole(Roles.ADMIN.getRole());

        account02.setEmail("account02@sunny.org");
        account02.setPassword("password02");
        account02.setFirstname("user02");
        account02.setLastname("amit");

        account03.setEmail("account03@sunny.org");
        account03.setPassword("password03");
        account03.setFirstname("user03");
        account03.setLastname("sunny");
        account03.setRole(Roles.EDITOR.getRole());

        // Super editor with extra privileges
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findByName("RESET_ANY_USER_PASSWORD")
                .ifPresent(authorities::add);

        authorityRepository.findByName("ACCESS_ADMIN_PANEL")
                .ifPresent(authorities::add);

        account04.setAuthorities(authorities);
        account04.setEmail("account04@sunny.org");
        account04.setPassword("password04");
        account04.setFirstname("super_editor");
        account04.setLastname("rinku");

        // Save accounts
        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        // Seed posts if empty
        List<Post> posts = postService.getAll();
        if (posts.isEmpty()) {
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("post 01 body .....");
            post01.setAccount(account01);
            postService.save(post01);
            System.out.println("Saved: " + post01.getTitle() + " with id=" + post01.getId());
            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("post 02 body .....");
            post02.setAccount(account02);
            postService.save(post02);
            System.out.println("Saved: " + post02.getTitle() + " with id=" + post02.getId());
        }
    }
}
