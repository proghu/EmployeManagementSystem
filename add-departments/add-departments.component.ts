import { Component } from '@angular/core';
import { DepartmentsService } from '../departments.service';
import { Departments } from '../departments';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-departments',
  templateUrl: './add-departments.component.html',
  styleUrls: ['./add-departments.component.css']
})
export class AddDepartmentsComponent {

  constructor(private departmentsService: DepartmentsService, private router:Router) { }

  departments = new Departments('', '', '','');

  onSubmit() {
    console.log(this.departments);
    this.departmentsService.addDeparment(this.departments).subscribe(
      (data: any) => {
        alert('Department added successfully');
        this.router.navigate(['/welcome']);
      }
    );
  }

}
