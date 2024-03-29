package org.example.crazycoin.services.interfaces;

import org.example.crazycoin.controllers.dtos.requests.CreateUserRequest;
import org.example.crazycoin.controllers.dtos.requests.ValidateUserRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);

    BaseResponse login(ValidateUserRequest request);
}
