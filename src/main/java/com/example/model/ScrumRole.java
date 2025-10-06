package com.example.model;

/**
 * Represents the set of roles defining user permissions
 * within the domain of the application, which is Scrum management.
 */
public enum ScrumRole {
    SCRUM_MASTER,    // Facilitates the process, removes blockers
    PRODUCT_OWNER,   // Owns the backlog, approves workflows
    DEVELOPER,       // Implements tasks, updates progress
    TESTER
}
