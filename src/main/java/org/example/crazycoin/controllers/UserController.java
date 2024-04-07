package org.example.crazycoin.controllers;

import org.example.crazycoin.controllers.dtos.requests.CreateUserRequest;
import org.example.crazycoin.controllers.dtos.requests.ValidateUserRequest;
import org.example.crazycoin.controllers.dtos.responses.BaseResponse;
import org.example.crazycoin.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateUserRequest request) {
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping("login")
    public ResponseEntity<BaseResponse> validate(@RequestBody ValidateUserRequest request){
        BaseResponse baseResponse = service.login(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable String id) {
        BaseResponse baseResponse = service.get(id);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
