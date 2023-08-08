import { Component } from '@angular/core';
import { EmployeesService } from '../employees.service';
import { Employees } from '../employees';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-employees',
  templateUrl: './add-employees.component.html',
  styleUrls: ['./add-employees.component.css']
})
export class AddEmployeesComponent {

  
  constructor(private employeesService: EmployeesService,private router:Router) { }

  employees = new Employees('', '', '', '', '', '', '');

  onSubmit() {
    console.log(this.employees);
    this.employeesService.addEmployee(this.employees).subscribe(
      (data: any) => {
        alert('Employee added successfully');
        this.router.navigate(['/welcome']);
      }
    );
  }


}
