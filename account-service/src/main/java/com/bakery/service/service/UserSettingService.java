package com.bakery.service.service;

import com.bakery.account.proto.UserSettingRequest;
import com.bakery.account.proto.UserSettingResponse;

public interface UserSettingService{
    UserSettingResponse createUser(UserSettingRequest request);
}
