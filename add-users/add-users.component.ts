import { Component } from '@angular/core';
import { UsersService } from '../users.service';
import { Users } from '../users';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.css']
})
export class AddUsersComponent {

  constructor(private userService: UsersService, private router:Router) { }

  users = new Users('', '', '', '', '', '', '', '', '', '');

  onSubmit() {
    console.log(this.users);
    this.userService.addUsers(this.users).subscribe(
      (data: any) => {
        alert('User added successfully');
        this.router.navigate(['/welcome']);
      }
    );
  }

}
