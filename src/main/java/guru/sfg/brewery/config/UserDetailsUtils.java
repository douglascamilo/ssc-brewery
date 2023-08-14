package guru.sfg.brewery.config;

import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
class UserDetailsUtils {

    static UserDetails build(String username, String password, String... roles) {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }


}
