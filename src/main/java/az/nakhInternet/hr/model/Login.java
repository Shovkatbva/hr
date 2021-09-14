package az.nakhInternet.hr.model;

import lombok.Data;

@Data
public class Login extends CommonModel {

    private Role role;
    private String name;
    private String surname;
    private String username;
    private String password;
}
