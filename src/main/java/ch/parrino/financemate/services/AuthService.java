package ch.parrino.financemate.services;


import ch.parrino.financemate.database.entities.UserAccount;
import ch.parrino.financemate.database.entities.UserAccountRepository;
import ch.parrino.financemate.model.SignInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserAccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username);
        return user;
    }

    public UserDetails signUp(SignInDto data) throws InvalidJwtException {
        if (repository.findByUsername(data.login()) != null) {
            throw new InvalidJwtException("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        //UserAccount newUser = new UserAccount(data.login(), encryptedPassword);
        UserAccount newUser = new UserAccount(data.login(), data.password());
        return repository.save(newUser);
    }
}
