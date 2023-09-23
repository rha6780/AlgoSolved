package com.example.algosolved.problem;

import com.example.algosolved.domain.problem.Problem;
import com.example.algosolved.domain.problem.ProblemController;
import com.example.algosolved.domain.problem.ProblemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProblemControllerTests {

    private MockMvc mvc;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new ProblemController())
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @AfterEach
    public void clean() {
        // 모든 테스트 이후에는 데이터 삭제
        problemRepository.deleteAll();
    }

    @Test
    @DisplayName("Problem Id에 따른 API 테스트")
    void getProblemByIdAPITest() throws Exception {

        Problem.builder().content("test problem").title("test").number(1);

        final ResultActions actions = mvc.perform(
                get("/api/v1/problem?id=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content("[{}]")
                );

        actions.andExpect(status().isOk());
    }
}
