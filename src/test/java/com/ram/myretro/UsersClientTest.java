package com.ram.myretro;

import com.ram.myretro.client.User;
import com.ram.myretro.client.UsersClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UsersClientTest {
    @Autowired UsersClient usersClient;

    @Test
    public void findUserTest() {
        User user = usersClient.findUserByEmail("norma@email.com");
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("Norma");
        assertThat(user.getEmail()).isEqualTo("norma@email.com");
    }
}
