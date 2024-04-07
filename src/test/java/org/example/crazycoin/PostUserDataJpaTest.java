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
class PostUserDataJpaTest {
    @Autowired
    private IUserRepository repository;

    @Test
    public void contextLoads() {
        User user = new User();

        user.setPassword("123");
        user.setEmail("axel@gmail.com");

        User u = repository.save(user);

        assertThat(u).isNotNull();
        assertThat(user.getEmail()).isNotNull();
        assertThat(user.getPassword()).isNotNull();
        assertThat(user.getEmail().chars().filter(ch -> ch == '@').count()).isEqualTo(1);
    }
}

