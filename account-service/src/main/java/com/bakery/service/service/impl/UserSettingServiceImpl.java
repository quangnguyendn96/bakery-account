package com.bakery.service.service.impl;

import com.bakery.account.proto.UserSettingRequest;
import com.bakery.account.proto.UserSettingResponse;
import com.bakery.service.entity.Users;
import com.bakery.service.repository.UserSettingRepository;
import com.bakery.service.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingServiceImpl implements UserSettingService {

    @Autowired
    private UserSettingRepository userSettingRepository;
    @Override
    public UserSettingResponse createUser(UserSettingRequest request) {
        Users users =  new Users();
        users.setPassword(request.getUserName());
        users.setEmail(request.getUserName());
        users.setUsername(request.getUserName());
        userSettingRepository.save(users);
        return UserSettingResponse.newBuilder()
                .setData(UserSettingResponse.Data.newBuilder()
                        .setSuccess(true).build())
                .build();
    }
}
