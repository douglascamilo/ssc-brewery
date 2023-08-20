package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncodingTest {

    static final String PASSWORD = "password";

    @Test
    void no_op_example() {
        var passwordEncoder = NoOpPasswordEncoder.getInstance();
        var encodedPassword = passwordEncoder.encode(PASSWORD);

        assertThat(encodedPassword).isEqualTo(PASSWORD);
    }

    @Test
    void md5_hashing_example() {
        var hashedPassword = DigestUtils.md5DigestAsHex(PASSWORD.getBytes());

        assertThat(hashedPassword).isEqualTo("5f4dcc3b5aa765d61d8327deb882cf99");
    }

    @Test
    void md5_hashing_example_with_salt() {
        var salted = PASSWORD + "ThisIsMySALTVALUE";
        var hashedPassword = DigestUtils.md5DigestAsHex(salted.getBytes());

        assertThat(hashedPassword).isEqualTo("b177e1b7fab112477a6b1754caa9ef06");
    }
}
