package org.example.crazycoin.services;

import org.example.crazycoin.controllers.dtos.requests.CreateUserRequest;
import org.example.crazycoin.controllers.dtos.requests.ValidateUserRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.controllers.dtos.responses.GetUserResponse;
import org.example.crazycoin.controllers.dtos.responses.ValidateUserResponse;
import org.example.crazycoin.entities.User;
import org.example.crazycoin.entities.projections.IUserProjection;
import org.example.crazycoin.repositories.IUserRepository;
import org.example.crazycoin.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(user)))
                .message("User created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse login(ValidateUserRequest request) {
        IUserProjection user = repository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());

        return BaseResponse.builder()
                .data(from(user))
                .message("User found correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private GetUserResponse from(User user){
        GetUserResponse response = new GetUserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());

        return response;
    }

    private User from(CreateUserRequest request){
        User response = new User();

        response.setName(request.getName());
        response.setPassword(request.getPassword());
        response.setEmail(request.getEmail());

        return response;
    }

    private ValidateUserResponse from(IUserProjection projection){
        ValidateUserResponse response = new ValidateUserResponse();

        response.setId(projection.getUserId());
        response.setPassword(projection.getUserPassword());
        response.setEmail(projection.getUserEmail());

        return response;
    }
}
