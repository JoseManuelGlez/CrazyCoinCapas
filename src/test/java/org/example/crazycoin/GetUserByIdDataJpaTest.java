package org.example.crazycoin;

import org.example.crazycoin.entities.User;
import org.example.crazycoin.repositories.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class GetUserByIdDataJpaTest {

    @Autowired
    private IUserRepository repository;

    @Test
    public void contextLoads() {
        User user = repository.findUserById("858fa181-6e16-45dc-b8a7-706d782b8075");
        assertThat(user).isNotNull();
    }
}
