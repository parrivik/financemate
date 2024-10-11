package ch.parrino.financemate.controllers;


import ch.parrino.financemate.database.entities.UserAccount;
import ch.parrino.financemate.model.JwtDto;
import ch.parrino.financemate.model.SignInDto;
import ch.parrino.financemate.model.SingUpDto;
import ch.parrino.financemate.security.TokenProvider;
import ch.parrino.financemate.services.AuthService;
import ch.parrino.financemate.services.InvalidJwtException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controllers/AuthController.java
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;


    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((UserAccount) authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDto(accessToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SingUpDto data) throws InvalidJwtException {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
