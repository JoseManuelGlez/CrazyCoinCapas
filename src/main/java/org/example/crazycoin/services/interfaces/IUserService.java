package org.example.crazycoin.services.interfaces;

import org.example.crazycoin.controllers.dtos.requests.CreateUserRequest;
import org.example.crazycoin.controllers.dtos.requests.ValidateUserRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.entities.User;

public interface IUserService {
    BaseResponse get(String request);

    User findOneAndEnsureExist(String id);

    BaseResponse create(CreateUserRequest request);

    BaseResponse login(ValidateUserRequest request);
}
