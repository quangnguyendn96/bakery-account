package com.bakery.service.grpc.server;

import com.bakery.account.proto.UserSettingRequest;
import com.bakery.account.proto.UserSettingResponse;
import com.bakery.account.proto.UsersSettingServiceGrpc;
import com.bakery.service.service.UserSettingService;
import com.sadlier.lms.account.proto.GetApplicationSettingResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
@Log4j2
public class AccountSettingServer extends UsersSettingServiceGrpc.UsersSettingServiceImplBase{

    @Autowired
    private UserSettingService userSettingService;

    @Override
    public void createUser(UserSettingRequest request, StreamObserver<UserSettingResponse> responseObserver){
        try {
            responseObserver.onNext(userSettingService.createUser(request));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onNext(UserSettingResponse.newBuilder()
                    .setSuccess(false)
                    .build());
            responseObserver.onCompleted();
            throw e;
        }
    }
}
