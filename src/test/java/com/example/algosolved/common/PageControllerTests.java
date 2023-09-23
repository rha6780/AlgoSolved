package com.example.algosolved.common;

import com.example.algosolved.common.config.PageController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PageController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class PageControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("루트 페이지 렌더링 테스트")
    void returnPageTest() throws Exception {
        String index = "index";

        mvc.perform(get("/")).andExpect(status().isOk());
    }

}
