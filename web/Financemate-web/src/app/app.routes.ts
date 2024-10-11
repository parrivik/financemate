import { Routes } from '@angular/router';
import {AppComponent} from './app.component';
import {LoginFormComponent} from './login-form/login-form.component';

export const routes: Routes = [
  {path: '', component: LoginFormComponent},
];
