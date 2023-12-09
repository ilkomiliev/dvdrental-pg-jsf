package dvdrental.pg.jsf.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(FixUserCredentials.class)
public class SecurityConfig {

    /**
     * Configure security - copied from JoinFaces example.
     **/
    @Bean
    public SecurityFilterChain configure(HttpSecurity http, MvcRequestMatcher.Builder mvc) {
        try {
            http.csrf(AbstractHttpConfigurer::disable);
            http
                    .authorizeHttpRequests((authorize) -> authorize
                            .requestMatchers(mvc.pattern("/")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/**.faces")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/jakarta.faces.resource/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/protected/customers.**")).hasAuthority("ADMIN")
                            .anyRequest().authenticated())
                    .formLogin((formLogin) ->
                            formLogin.loginPage("/login.faces")
                                    .permitAll()
                                    .failureUrl("/login.faces?error=true")
                                    .defaultSuccessUrl("/index.faces"))
                    .logout((logout) ->
                            logout.logoutSuccessUrl("/login.faces")
                                    .deleteCookies("JSESSIONID"));
            return http.build();
        }
        catch (Exception ex) {
            throw new BeanCreationException("Wrong spring security configuration", ex);
        }
    }

    @Scope("prototype")
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    /**
     * UserDetailsService that configures an in-memory users store.
     * @param applicationUsers - autowired users from the application.yml file
     * @return InMemoryUserDetailsManager - a manager that keeps all the users' info in the memory
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService(FixUserCredentials applicationUsers) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager result = new InMemoryUserDetailsManager();
        for (UserCredentials userCredentials : applicationUsers.getUserCredentials()) {
            UserDetails userDetails = User.builder()
                    .username(userCredentials.getUsername())
                    .password(encoder.encode(userCredentials.getPassword()))
                    .authorities(userCredentials.getAuthorities().toArray(new String[0])).build();
            result.createUser(userDetails);
        }
        return result;
    }
}
