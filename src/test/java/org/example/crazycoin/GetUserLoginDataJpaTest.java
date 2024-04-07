package org.example.crazycoin;

import org.example.crazycoin.controllers.dtos.requests.ValidateUserRequest;
import org.example.crazycoin.entities.projections.IUserProjection;
import org.example.crazycoin.repositories.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GetUserLoginDataJpaTest {
    @Autowired
    private IUserRepository repository;

    @Test
    public void contextLoads() {
        ValidateUserRequest request = new ValidateUserRequest();

        request.setEmail("jose@gmail.com");
        request.setPassword("123");

        IUserProjection user = repository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());
        assertThat(user).isNotNull();
        assertThat(request.getEmail()).isNotNull();
        assertThat(request.getPassword()).isNotNull();
        assertThat(request.getEmail().chars().filter(ch -> ch == '@').count()).isEqualTo(1);
    }
}
