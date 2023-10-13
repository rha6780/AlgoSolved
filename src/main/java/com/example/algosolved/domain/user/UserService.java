package com.example.algosolved.domain.user;

import com.example.algosolved.domain.user.dto.LoginDto;
import com.example.algosolved.domain.user.dto.LoginResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username or email"));
        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Transactional //선언적 트랜잭션 : 오류가 있다면 롤백
    public void signUpUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public LoginResponseDto login(LoginDto loginDto) {
        Optional<User> user = userRepository.findByUsernameOrEmail(loginDto.getEmail(), loginDto.getEmail());

        System.out.println("user : "+user);
        if(user == null) {

            return LoginResponseDto.builder().isValid(false).field("email").build();
        }
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

            log.info("Authentication: {}", authentication);

            System.out.println("authentication : "+authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return LoginResponseDto.builder().isValid(true).field("none").build();
        } catch (AuthenticationException exception) {
            log.debug("invalid request: {}", exception);
            System.out.println("try-catch!");
            return LoginResponseDto.builder().isValid(false).field("password").build();
        }

    }

}
