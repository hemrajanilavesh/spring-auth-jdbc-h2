package io.hemrlav.springsecurityjdbch2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * Configures Authentication Manager to use embedded H2 database as Identity Store.
     * Schema.sql is used to create default authentication schema in H2 on start-up.
     * Data.sql inserts two users with their corresponding roles in the embedded H2 database on start-up.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource);
    }

    /**
     * Configures Authorization in terms of Roles required to access an API.
     *
     * always authorize requests from most restrictive to least restrictive.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/greet/director").hasRole("Director")
                .and()
                .authorizeRequests()
                .antMatchers("/greet/avenger").hasAnyRole("Director", "Avenger")
                .and()
                .authorizeRequests()
                .antMatchers("/greet").permitAll()
                .and().httpBasic(); // to allow api calls from post mand with basic auth

        // so that it also allow login / logout via browser
        http.formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // does nothing to the password
        return NoOpPasswordEncoder.getInstance();
    }
}
