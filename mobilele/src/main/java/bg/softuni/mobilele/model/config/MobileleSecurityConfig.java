package bg.softuni.mobilele.model.config;

import bg.softuni.mobilele.service.impl.MobileleUserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MobileleSecurityConfig extends WebSecurityConfigurerAdapter {

  private final MobileleUserDetailsServiceImpl userDetailsService;
  private final PasswordEncoder passwordEncoder;

  public MobileleSecurityConfig(MobileleUserDetailsServiceImpl userDetailsService,
      PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.
        authorizeRequests().
          // allow access to static resources to anyone
          antMatchers("/js/**", "/css/**", "/img/**").permitAll().
          // allow access to index, user login and registration to anyone
          antMatchers("/", "/users/login", "/users/register", "/offers/all", "/brands/all").permitAll().
          // protect all other pages
          antMatchers("/**").authenticated().
        and().
          // configure login with HTML form
          formLogin().
            // our login page will be served by the controller with mapping /users/login
            loginPage("/users/login").
            // the name of the user name input field in OUR login form is username (optional)
            usernameParameter("username").
            // the name of the user password input field in OUR login form is password (optional)
            passwordParameter("password").
            // on login success redirect here
            defaultSuccessUrl("/").
            // on login failure redirect here
            failureForwardUrl("/users/login-error").
        and().
          logout().
          logoutUrl("/users/logout").
          logoutSuccessUrl("/").
          invalidateHttpSession(true).
          deleteCookies("JSESSIONID");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.
        userDetailsService(userDetailsService).
        passwordEncoder(passwordEncoder);
  }
}
