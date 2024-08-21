package org.taskmanage;

public class User {
    private final String id;
    private String name;
    private String email;

    User(String name, String email) {
        this.id = generateId();
        this.name = name;
        this.email = email;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }
}
