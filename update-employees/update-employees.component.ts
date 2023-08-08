import { Component, OnInit } from '@angular/core';
import { Employees } from '../employees';
import { EmployeesService } from '../employees.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-update-employees',
  templateUrl: './update-employees.component.html',
  styleUrls: ['./update-employees.component.css']
})
export class UpdateEmployeesComponent implements OnInit{
 

  empId: any;
  employees = new Employees('', '', '', '', '', '','');

  constructor(private employeesService: EmployeesService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.empId = this.activatedRoute.snapshot.params['empId'];
    this.employeesService.getEmployeeById(this.empId).subscribe(
      (data: any) => {
        this.employees = data;
      }
    );
  }

  onSubmit() {
    this.employeesService.updateEmployee(this.empId, this.employees).subscribe(
      (data: any) => {
        alert('Employee updated successfully');
        this.router.navigate(['/employees']);
      }
    );
  }

}
