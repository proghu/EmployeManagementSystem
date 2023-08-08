import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { UsersService } from '../users.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-user-mobile',
  templateUrl: './update-user-mobile.component.html',
  styleUrls: ['./update-user-mobile.component.css']
})
export class UpdateUserMobileComponent implements OnInit{

  mobilenumber: any;
  users = new Users('', '', '', '', '', '', '', '', '', '');

  constructor(private userService: UsersService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    
    this.mobilenumber = this.activatedRoute.snapshot.params['mobilenumber'];
    console.log(this.mobilenumber);
    this.userService.getUserByMobile(this.mobilenumber).subscribe(
      (data: any) => {
        this.users = data;
      }
    );
  }

  onSubmit() {
    this.userService.updateUserByMobile(this.mobilenumber,this.users).subscribe(
      (data: any) => {
        alert('User updated successfully');
        this.router.navigate(['']);
      }
    );
  }

}
