package az.nakhInternet.hr.service.impl;

import az.nakhInternet.hr.dao.LoginDao;
import az.nakhInternet.hr.model.Login;
import az.nakhInternet.hr.service.LoginService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao;

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username, password);
    }
}
