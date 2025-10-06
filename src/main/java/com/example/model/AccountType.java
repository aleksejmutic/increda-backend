package com.example.model;

/**
 * Defines the high-level type of account within the system.
 * This describes how the user registered or what kind of identity they have,
 * not their permissions. Defines privileges on the higher level of the system.
 */
public enum AccountType {
    USER,
    ADMIN,
    GUEST
}
