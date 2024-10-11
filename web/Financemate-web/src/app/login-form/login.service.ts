import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {

  }

  public login(userName: string, password: string) {
    let loginBody = {
      "login": userName,
      "password": password
    }
    console.log("loginBody", loginBody);
   return this.http.post("https://localhost:8080/auth/signin", loginBody).pipe(
     //nehme resultat vom Post aufruf
     tap(value => localStorage.setItem("token", JSON.stringify(value)))
   )
  }

}
