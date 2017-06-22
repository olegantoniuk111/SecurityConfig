package vin.gans.config;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vin.gans.config.handler.SuccessLoginHandler;
import vin.gans.domain.Role;
import vin.gans.domain.User;
import vin.gans.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    public SuccessLoginHandler successLoginHandler(){
        return new SuccessLoginHandler();
    }

    @Bean
    public UserDetailsService userService() throws Exception {
        return new UserService();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth
                    .userDetailsService(userService())
                    .passwordEncoder(bcriptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registerForm").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").successHandler(successLoginHandler()).permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }
    @Bean
    public PasswordEncoder bcriptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
