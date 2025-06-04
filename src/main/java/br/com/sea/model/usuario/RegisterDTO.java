package br.com.sea.model.usuario;

import javax.validation.constraints.NotBlank;

public class RegisterDTO {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private UserRole role;

    public RegisterDTO() {}

    public RegisterDTO(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
