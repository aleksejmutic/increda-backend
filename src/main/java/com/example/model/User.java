package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password; // nullable for OAuth users

    @Enumerated(EnumType.STRING)
    private AccountType accountType; // USER, ADMIN, GUEST

    @Enumerated(EnumType.STRING)
    private OAuthProvider oauthProvider; // NONE, GOOGLE, GITHUB

    @Enumerated(EnumType.STRING)
    private AccountStatus status; // ACTIVE, SUSPENDED, DELETED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<SystemRole> roles; // ADMIN, USER, GUEST, etc.

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
