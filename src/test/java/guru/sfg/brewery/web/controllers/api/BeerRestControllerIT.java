package guru.sfg.brewery.web.controllers.api;

import guru.sfg.brewery.web.controllers.BaseIT;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerRestControllerIT extends BaseIT {

    @Test
    @SneakyThrows
    void should_find_beers_successfully() {
        mockMvc.perform(get("/api/v1/beer/"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void should_find_beer_by_id_successfully() {
        mockMvc.perform(get("/api/v1/beer/4d5409f7-cb31-4d03-9244-32408d4b44a5"))
                .andExpect(status().isOk());
    }

}