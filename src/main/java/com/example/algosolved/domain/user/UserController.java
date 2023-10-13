package com.example.algosolved.domain.user;

import com.example.algosolved.domain.role.RoleRepository;
import com.example.algosolved.domain.user.dto.LoginDto;
import com.example.algosolved.domain.user.dto.LoginResponseDto;
import com.example.algosolved.domain.user.dto.SignUpDto;
import com.example.algosolved.domain.user.dto.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@RequestBody LoginDto loginDto) {
        LoginResponseDto loginResponseDto = userService.login(loginDto);
        System.out.println("loginDTO : "+loginResponseDto);
        if (loginResponseDto == null) {
            return ResponseEntity.badRequest().body(loginResponseDto);
        }
        if (loginResponseDto.getIsValid().booleanValue() == true) {
            return ResponseEntity.ok(loginResponseDto);
        } else {
            return ResponseEntity.badRequest().body(loginResponseDto);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> registerUser(@RequestBody SignUpDto signUpDto) {
        if(userRepository.existsByEmail(signUpDto.getEmail())) {
            return ResponseEntity.badRequest().body(new SignUpResponseDto(false, "email"));
        }

        User user = new User(signUpDto.getName(), signUpDto.getEmail(), signUpDto.getPassword());

        userService.signUpUser(user);

        return ResponseEntity.ok(new SignUpResponseDto(true, "none"));
    }

}
