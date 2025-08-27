package org.sunny.SpringStarter.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String email;
   private String password;
   private String firstname;
   private String lastname;
   private String role;

   @OneToMany(mappedBy="account")

   private List<Post> posts;
   
    @ManyToMany
    @JoinTable(
        name="account_authority",
        joinColumns={@JoinColumn(name="account_id", referencedColumnName="id")},
        inverseJoinColumns= {@JoinColumn(name="authority_id", referencedColumnName="id")}
    )
        private Set<Authority> authorities= new HashSet<>();
    

//     public String getEmail() { return email; }
//     public void setEmail(String email) {this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getFirstname() { return firstname; }
//     public void setFirstname(String firstname) { this.firstname = firstname; }
//     public Long getId() { return id; }
// public void setId(Long id) { this.id = id; }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }

//     public void setLastname(String lastname) {
//         this.lastname= lastname;
//     }

}
