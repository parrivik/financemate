import { Component } from '@angular/core';

import { RouterOutlet } from '@angular/router';
import {MatCard, MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatFormField, MatFormFieldModule} from '@angular/material/form-field';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatIcon, MatIconModule} from '@angular/material/icon';
import {MatButton, MatIconButton} from '@angular/material/button';
import {LoginService} from './login.service';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [MatCardModule, MatChipsModule, MatFormFieldModule, ReactiveFormsModule, MatInputModule, MatIconModule, MatIconButton, MatButton],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent {

  title = 'FinancemateWeb';

  passwordHidden = true;
  loginForm=new FormGroup({
    email: new FormControl<string|null>('', Validators.required),
    password: new FormControl<string|null>('', Validators.required),

  })
  constructor(private loginService: LoginService) {
  }

  hide() {
    return this.passwordHidden;
  }

  togglePasswordVisibility($event: MouseEvent) {
    this.passwordHidden = !this.passwordHidden;

  }

  onsubmit(){
    let loginData = this.loginForm.value;
    console.log(loginData);
    this.loginService.login(<string>loginData.email, <string>loginData.password).subscribe();
  };

}
