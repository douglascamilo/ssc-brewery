package guru.sfg.brewery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static guru.sfg.brewery.config.UserDetailsUtils.build;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new LdapShaPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/", "/login", "/webjars/**", "/resources/**").permitAll()
                        .antMatchers("/beers/find", "/beers*").permitAll()
                        .antMatchers(GET, "/api/v1/beer/*").permitAll()
                        .mvcMatchers(GET, "/api/v1/beerUpc/{upc}").permitAll()
                )
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(build("spring", "guru", "ADMIN"))
                .withUser(build("user", "{SSHA}w5MHMUPBjGeEUTiP+hOocWUxPZr55CeIR72qcg==", "USER"))
                .withUser(build("scott", "{SSHA}OrEXghUwoliDCUhUx3g0Hpjfi3yOh1pXPZ8vjQ==", "CUSTOMER"))
        ;
    }

}
