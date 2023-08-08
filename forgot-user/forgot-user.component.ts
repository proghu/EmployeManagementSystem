import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-forgot-user',
  templateUrl: './forgot-user.component.html',
  styleUrls: ['./forgot-user.component.css']
})
export class ForgotUserComponent implements OnInit {

  mobilenumber:any;

  constructor(private router: Router, private userService: UsersService) { }

  ngOnInit(): void {

  }

  FindMobile(mobilenumber:any): void {
    // Call the user service to perform login
    console.log(this.mobilenumber);
    this.userService.getUserByMobile(this.mobilenumber).subscribe(
      (response) => {
        // Successful login
        this.router.navigate(['/update-user-mobile',mobilenumber]);
      },
      (error) => {
        // Failed login
        alert("Inavaild Mobile Number");
      }
    );
  }

}
