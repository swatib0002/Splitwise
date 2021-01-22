package Service;

import models.User;

public interface IUserService {

    User createUser(String name, String email, long number);

    void showBalance(String userId);
}
