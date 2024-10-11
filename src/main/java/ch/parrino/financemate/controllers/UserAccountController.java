package ch.parrino.financemate.controllers;

import ch.parrino.financemate.database.entities.UserAccount;
import ch.parrino.financemate.model.UserAccountModel;
import ch.parrino.financemate.services.UserAccountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/UserAccount")
@SecurityRequirement(name = "bearerAuth")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public UserAccountModel getUserAccount(long id) {

        UserAccountModel model = new UserAccountModel();
        UserAccount userAccount = userAccountService.getUserAccount(id);
        model.username = userAccount.username;
        return model;

    };

    @PostMapping
    public void postUserAccount(@RequestBody UserAccountModel model) {

        UserAccount userAccount = new UserAccount();
        userAccount.username = model.username;
        userAccountService.saveUserAccount(userAccount);
    }

    @PutMapping
    public void putUserAccount(long id, @RequestBody UserAccountModel model) {
        UserAccount userAccount = new UserAccount();
        userAccount.username = model.username;
        userAccount.id = id;
        userAccountService.saveUserAccount(userAccount);

    }



    @DeleteMapping
    public void deleteUserAccount(long id) {
        userAccountService.deleteUserAccount(id);
    }

}
