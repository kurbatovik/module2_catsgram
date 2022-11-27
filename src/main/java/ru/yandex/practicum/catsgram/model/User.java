package ru.yandex.practicum.catsgram.model;

import java.time.LocalDate;

public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public User setBirthdate(String birthdate) {
        String[] date = birthdate.split("-");
        this.birthdate = LocalDate.of(Integer.parseInt(date[0]),
                Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode() * 31;
    }
}
