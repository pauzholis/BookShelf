package ru.testproject.bookshelf.view;


public class UserView {
    public Long id;
    public String email;
    public String password;
    public Boolean active;

    public UserView() {
    }

    public UserView(String email, String password, Boolean active) {
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
