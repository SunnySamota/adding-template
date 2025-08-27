package org.sunny.SpringStarter.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Post") 
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   

    @Column(nullable = false, length = 150)
    private String title;  

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;   

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account; 

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
