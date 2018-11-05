package  com.example.hackathronaplication.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    // konfiguracja zabezpieczeń
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hack/profilT").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/hack/logowanie")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login-process")
                    .defaultSuccessUrl("/hack/profilT")
                .and()
                .logout()
                .logoutUrl("/hack/logout")
                .logoutSuccessUrl("/hack/logout");



    }
    // autoryzacja w oparciu o DB
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT t.email, t.password, t.active FROM team t WHERE t.email = ?")
                .authoritiesByUsernameQuery("SELECT t.email, t.permission FROM team t WHERE t.email = ?")
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

}
