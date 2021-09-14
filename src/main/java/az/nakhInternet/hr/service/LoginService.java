package az.nakhInternet.hr.service;

import az.nakhInternet.hr.model.Login;

public interface LoginService {

    Login login(String username, String password) throws Exception;
}
