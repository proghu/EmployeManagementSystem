import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private userService: UsersService) { }

  ngOnInit(): void {
  }

  login(): void {
    // Call the user service to perform login
    this.userService.login(this.username, this.password).subscribe(
      (response) => {
        // Successful login
        this.router.navigate(['/welcome']);
      },
      (error) => {
        // Failed login
        this.errorMessage = 'Invalid username or password';
      }
    );
  }

  public goToSignUp(){
    this.router.navigate(['/add-users']);
  }

  public goToForgotUser() {
    this.router.navigate(['/forgot-user']);
  }

}
