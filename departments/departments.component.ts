import { Component } from '@angular/core';
import { DepartmentsService } from '../departments.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent {

  DepartmentsList:any;

  jobName:any;

  constructor(private departmentService:DepartmentsService,private router : Router){}

  ngOnInit(): void {
    
    this.getAllDepartment();
  }

  public getAllDepartment(){
    this.departmentService.getAllDepartments().subscribe(
  (data:any)=>{
    this.DepartmentsList=data;
  }
);
}

public searchEmployee(){
  console.log(this.jobName);

  if (!this.jobName) {
    // Display an alert if the input text is empty
    alert("Please enter a search term.");
    return;
  }

  this.departmentService.getDepartmentByjobName(this.jobName).subscribe(

      (data:any)=>{
        if (data.length === 0) {
          // Display an alert if no data is found
          alert("No matching data found.");
        } else {
          // Set the EmployeesList if data is found
          this.DepartmentsList = data;
        }
      }
  )
}





public updateDepartmet(jobId:any){
  this.router.navigate(['/update-departments',jobId]);
  }

  public deleteDepartment(jobId:any){
    console.log(jobId);
    this.departmentService.deleteDepartment(jobId).subscribe(
      (data:any)=>{
        this.DepartmentsList=data;
        alert("data deleted successfuly");
       this.router.navigate(['/departments']) ;
      }
    )
    
  }


  public listSalaryBonus(){
    this.router.navigate(['/salary-bonus']);
    }
    
    public AddSalaryBonus(){
      this.router.navigate(['/add-salary-bonus']) ;  
    }


}
