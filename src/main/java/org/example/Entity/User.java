package org.example.Entity;

import java.util.Objects;

public class User {
    private String name;
    private String email;
    private Long id;

    public User(builder builder) {
        this.name = Objects.requireNonNull(builder.name, "name");
        this.email = Objects.requireNonNull(builder.email, "email");
        this.id = builder.id;
    }

    public static class builder{
        private String name;
        private String email;
        private Long id;

        public builder setName(String name) {
            this.name = name;
            return this;
        }

        public builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public builder setId(long id) {
            this.id = id;
            return this;
        }

        public User build(){return new User(this);}
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) return false;

        return id == user.id && name.equals(user.name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + Long.hashCode(id);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
