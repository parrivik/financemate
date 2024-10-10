package ch.parrino.financemate.services;

import ch.parrino.financemate.database.entities.UserAccount;
import ch.parrino.financemate.database.entities.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount getUserAccount(long id) {
        //userAccountRepository.findById(id);
        return userAccountRepository.findById(id).get();
    }

    public void saveUserAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);

    }

    public void deleteUserAccount(long id) {
        userAccountRepository.deleteById(id);
    }
}
