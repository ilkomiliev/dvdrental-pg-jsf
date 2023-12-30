package dvdrental.pg.jsf.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@ConditionalOnProperty(name = "dvdrental.security.enable", havingValue = "false")
public class DisableSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) {
        try {
            http.csrf(AbstractHttpConfigurer::disable);
            http.authorizeHttpRequests(
                    authz -> authz.anyRequest().permitAll());
            return http.build();
        }
        catch (Exception ex) {
            throw new BeanCreationException("Wrong spring security configuration", ex);
        }
    }
}
