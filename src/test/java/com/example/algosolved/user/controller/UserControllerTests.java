package com.example.algosolved.user;

import com.example.algosolved.domain.user.User;
import com.example.algosolved.domain.user.UserController;
import com.example.algosolved.domain.user.UserRepository;
import com.example.algosolved.domain.user.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    private MockMvc mockMvc;

    @BeforeEach //각 테스트마다 mockMvc를 설정해준다.
    public void mvcSetting() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }


    @Test
    @DisplayName("로그인 성공")
    void loginSuccess() throws Exception {
        userRepository.save(
                User.builder()
                        .name("test1")
                        .password("test")
                        .email("test@email.com")
                        .build()
        );

        final ResultActions actions = mockMvc.perform(
                post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content("{\"email\":\"test@email.com\",\"password\":\"test\"}"));


        actions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 실패 - 이메일 찾지 못함")
    void loginFailNotExistEmail() {

    }

    @Test
    @DisplayName("로그인 실패 - 비밀번호 틀림")
    void loginFailInvalidPassword() {

    }

    @Test
    @DisplayName("회원가입 성공")
    void signUpSuccess() {

    }

    @Test
    @DisplayName("회원가입 실패 - 이미 있는 이메일")
    void signUpFailExistsEmail() {

    }

    @Test
    @DisplayName("회원가입 실패 - 유효하지 않는 비밀번호")
    void signUpFailInvalidPassword() {

    }

}

