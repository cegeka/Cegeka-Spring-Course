package com.cegeka.springcourse.testing.foodproduct;

import com.cegeka.springcourse.testing.TestingApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class FoodProductControllerE2ETest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void calculateSP() throws Exception {
        ObjectMapper mapper = new ObjectMapper();


        mvc.perform(MockMvcRequestBuilders
                .post(URI.create("/foodproduct"))
                .content(mapper.writeValueAsString(new FoodProduct("lasagna", 330, 660, 3300,0,250)))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        // ((10 * 33) + (8 * 33) + (90 * 33) -0 ) * 4
        // (((330) + (4*660) + (9*3300) - 0) / 33) * 4
        //990 * 4 = 3960
        String actual = mvc.perform(MockMvcRequestBuilders.get(URI.create("/foodproduct/lasagna/sp/1000")))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertThat(actual).isEqualTo("3960.0");
    }
}