package com.tnt.hp.Service;

import com.tnt.hp.Entity.User;

public interface UserService {

  public String addUser(User newUser);

  public String signIn(String emailId, String password);

}
