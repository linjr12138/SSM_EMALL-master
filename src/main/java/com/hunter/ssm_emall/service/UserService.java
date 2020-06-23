package com.hunter.ssm_emall.service;

import com.hunter.ssm_emall.bean.User;

public interface UserService {

    User getUser(String username, String password);

    int saveUser(String userName, String password, String nickName);
}
