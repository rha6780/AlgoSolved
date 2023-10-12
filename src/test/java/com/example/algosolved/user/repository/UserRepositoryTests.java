package com.example.algosolved.user.repository;

import com.example.algosolved.domain.user.User;
import com.example.algosolved.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 save 성공")
    public void saveUserTest() {
        User user = User.builder().email("test@test.com").name("test1").password("test-Password").build();

        User result = userRepository.save(user);

        Assertions.assertThat(user).isEqualTo(result);
    }

    @Test
    @DisplayName("유저 findById 성공 - Id가 있는 경우")
    public void findByIdTest() {
        User user = User.builder().email("test@test.com").name("test1").password("test-Password").build();
        userRepository.save(user);

        User result = userRepository.findById(user.getId()).get();

        Assertions.assertThat(user.getId()).isSameAs(result.getId());
        Assertions.assertThat(user.getName()).isSameAs(result.getName());
        Assertions.assertThat(user.getEmail()).isSameAs(result.getEmail());
        Assertions.assertThat(user.getPassword()).isSameAs(result.getPassword());
    }

    @Test
    @DisplayName("유저 findById 실패 - Id가 없는 경우")
    public void findByIdNonExistsIdTest() {

        Optional<User> result = userRepository.findById(1L);

        Assertions.assertThat(result.isPresent()).isFalse();
    }

    @Test
    @DisplayName("유저 findByEmail 성공 - Email이 있는 경우")
    public void findByEmailTest() {
        User user = User.builder().email("test@test.com").name("test1").password("test-Password").build();
        userRepository.save(user);

        User result = userRepository.findByEmail("test@test.com").get();

        Assertions.assertThat(result.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    @DisplayName("유저 findByEmail 실패 - Email이 없는 경우")
    public void findByEmailNonExistsEmailTest() {

        Optional<User> result = userRepository.findByEmail("test@test.com");

        Assertions.assertThat(result.isPresent()).isFalse();
    }

}
