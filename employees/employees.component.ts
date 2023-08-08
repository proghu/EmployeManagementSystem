import { Component, OnInit } from '@angular/core';
import { EmployeesService } from '../employees.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  EmployeesList:any;

  firstName:any;

  constructor(private employeesService:EmployeesService,private router : Router){}

  ngOnInit(): void {
    
    this.getAllEMployee();
  }

  public getAllEMployee(){
    this.employeesService.getAllEmployees().subscribe(
  (data:any)=>{
    this.EmployeesList=data;
  }
);
}

public searchEmployee(){
  console.log(this.firstName);

  if (!this.firstName) {
    // Display an alert if the input text is empty
    alert("Please enter a search term.");
    return;
  }

  this.employeesService.getEmployeeByName(this.firstName).subscribe(

      (data:any)=>{
        if (data.length === 0) {
          // Display an alert if no data is found
          alert("No matching data found.");
        } else {
          // Set the EmployeesList if data is found
          this.EmployeesList = data;
        }
      }
  )
}


public updateEmployee(empId:any){
  this.router.navigate(['/update-employees',empId]);
  }

  public deleteEmployee(empId:any){
    console.log(empId);
    this.employeesService.deleteEmployee(empId).subscribe(
      (data:any)=>{
        this.EmployeesList=data;
        alert("data deleted successfuly");
       this.router.navigate(['/employees']) ;
      }
    )
    
  }

public listQualifications(){
  this.router.navigate(['/qualifications']);
}

public addQualification(){
  this.router.navigate(['/add-qualifications']);
}

public listLeaves(){
  this.router.navigate(['/leaves']);
  }
  
  public AddLeave(){
    this.router.navigate(['/add-leaves']) ;  
  }


}
