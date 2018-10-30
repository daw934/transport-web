package pl.transport.transportapp.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

//    @Bean
//    public UserDetailsService customUserDetailsService() {
//        return new CustomUserDetailsService();
//    }

    @Autowired
    private UserDetailsService customUserDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).
//                usersByUsernameQuery("select email,password, enabled from user where username=?")
//                .authoritiesByUsernameQuery("select username, role from user_roles where username=?"););
//    }

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll().antMatchers("/menu").permitAll()
//                .antMatchers("/register").permitAll().antMatchers("/registrationConfirm").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginProcessingUrl("/processlogin").defaultSuccessUrl("/").failureUrl("/");
////    .loginPage("/loginpage").permitAll().
//        System.out.println("---=---------------------------------");

        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register").permitAll()
                .antMatchers("/api/**").permitAll()
        .anyRequest().authenticated().and().formLogin().permitAll().and().logout().logoutSuccessUrl("/");
//        http.authorizeRequests().antMatchers("/**").permitAll().and().logout().logoutSuccessUrl("/");
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
  @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


}
