package az.nakhInternet.hr.dao;

import az.nakhInternet.hr.model.Login;

public interface LoginDao {

    Login login(String username, String password) throws Exception;
}
