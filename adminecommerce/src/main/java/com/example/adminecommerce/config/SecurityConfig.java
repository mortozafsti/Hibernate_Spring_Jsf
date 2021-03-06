//package com.example.adminecommerce.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = com.example.adminecommerce.repo.UserRepo.class)
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private LoggingAccessDeniedHandler accessDeniedHandler;
//
//    @Autowired
//    CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return  new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("/public/**","/login","/css/**","/js/**","/images/**","/fonts/**").permitAll()
//                .antMatchers("/ngo/**","/role/**").hasRole("SUPERADMIN")
//                .antMatchers("/adm/**").hasRole("ADMIN")
//                .antMatchers("/u/**","/user/**").hasAnyRole("USER","SUPERADMIN")
//                .antMatchers("/se/**").hasAnyRole("ADMIN","USER","SUPERADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler);
//
//    }
//
////    @Bean
////    @Override
////    protected UserDetailsService userDetailsService() {
////
////        UserDetails userDetails = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
////
////        return new InMemoryUserDetailsManager(userDetails);
////    }
//}
