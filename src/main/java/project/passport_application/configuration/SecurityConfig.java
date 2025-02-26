//package project.passport_application.configuration;
//
////import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import project.passport_application.repository.UserRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    private final UserRepository userRepository;
//
//    // Inject UserRepository to fetch users from the database
//    public SecurityConfig(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeRequests()
//                .requestMatchers("/login", "/register").permitAll()  // Allow public access to login and register
//                .requestMatchers("/passport/**").hasRole("USER")    // Only users with the ROLE_USER can access passport APIs
//                .anyRequest().authenticated()                    // Any other request requires authentication
//            .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()                                      // Allow everyone to access login page
//            .and()
//            .logout()
//                .permitAll();                                     // Allow everyone to logout
//    }
//
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
////
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        // In-memory authentication (for testing) or Database authentication logic
////        auth.userDetailsService(userDetailsService())
////            .passwordEncoder(passwordEncoder());
////    }
//
//    // Custom userDetailsService that fetches user from the database
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return username -> userRepository.findById(username)
////                .map(user -> User.builder()
////                        .username(user.getUsername())
////                        .password(user.getPassword())  // Store password securely with encoding
////                        .roles(user.getRole())         // Assign role (e.g., "USER")
////                        .build())
////                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
////    }
//
//    // Password encoder bean
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Use BCrypt for password encryption
//    }
//}
