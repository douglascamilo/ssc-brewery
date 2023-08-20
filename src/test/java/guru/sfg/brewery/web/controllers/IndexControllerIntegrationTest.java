package guru.sfg.brewery.web.controllers;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class IndexControllerIntegrationTest extends BaseIT {

    @Test
    @SneakyThrows
    void should_make_get_request_to_index_slash() {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}
