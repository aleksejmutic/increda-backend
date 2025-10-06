package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "project_membership")
public class ProjectMembership {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private ScrumRole role; // SCRUM_MASTER, PRODUCT_OWNER, DEVELOPER, TESTER

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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
