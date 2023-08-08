import { Component, OnInit } from '@angular/core';
import { LeavesService } from '../leaves.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leaves',
  templateUrl: './leaves.component.html',
  styleUrls: ['./leaves.component.css']
})
export class LeavesComponent implements OnInit{

   ListLeaves:any;

   leavesByempId:any;

  constructor(private leaveService: LeavesService, private router : Router){}

  public ngOnInit(): void {
   this.getAllLeaves();
  }


    public getAllLeaves(){
      this.leaveService.getAllLeaves().subscribe(
        (data: any) => {
  
          this.ListLeaves = data.map((leave: any) => ({
            leave_ID: leave.leave_ID,
            empId: leave.employee.empId,
            firstName: leave.employee.firstName,
            lastName: leave.employee.lastName,
            date: leave.date,
            reason: leave.reason
          }));
        }
      );
    }


    public searchEmployee() {
      console.log(this.leavesByempId);
    
      if (!this.leavesByempId) {
        // Display an alert if the input text is empty
        alert("Please enter a search term.");
        return;
      }
    
      this.leaveService.getEmployeeLeaves(this.leavesByempId).subscribe(
        (data: any) => {
          if (data.length === 0) {
            // Display an alert if no data is found
            alert("No matching data found.");
          } else {
            // Set the ListQualifications if data is found
            this.ListLeaves = data.map((leave: any) => ({
              leave_ID: leave.leave_ID,
              empId: leave.employee.empId,
              firstName: leave.employee.firstName,
              lastName: leave.employee.lastName,
              date: leave.date,
              reason: leave.reason
            }));
          }
        },
        (error: any) => {
          // Handle error if the HTTP request fails or empId is not found
          alert("Error occurred while fetching data. Please try again later or check the entered employee ID.");
        }
      );
    }

    public updateLeave(leave_ID:any){
      this.router.navigate(['/update-leaves',leave_ID]);
      }

      public deleteLeave(leave_ID:any){
        console.log(leave_ID);
        this.leaveService.deleteLeave(leave_ID).subscribe(
          (data:any)=>{
            this.ListLeaves=data;
            alert("data deleted successfuly");
           this.router.navigate(['/leaves']) ;
          }
        )
        
      }


}
