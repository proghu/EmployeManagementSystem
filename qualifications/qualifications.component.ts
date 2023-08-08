import { Component, OnInit } from '@angular/core';
import { QualificationsService } from '../qualifications.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-qualifications',
  templateUrl: './qualifications.component.html',
  styleUrls: ['./qualifications.component.css']
})
export class QualificationsComponent implements OnInit{


 
  ListQualifications:any;

  qualificationsByempId:any;

  constructor(private qualificationsServices: QualificationsService, private router : Router){}

  public ngOnInit(): void {
   this.getAllQualification();
  }


    public getAllQualification(){
      this.qualificationsServices.getAllLeaves().subscribe(
        (data: any) => {
  
          this.ListQualifications = data.map((qualification: any) => ({
            qualificationId: qualification.qualificationId,
            empId: qualification.employee.empId,
            firstName: qualification.employee.firstName,
            lastName: qualification.employee.lastName,
            position: qualification.position,
            requirements: qualification.requirements,
            dateIn:qualification.dateIn
          }));
        }
      );
    }


    public searchEmployee() {
      console.log(this.qualificationsByempId);
    
      if (!this.qualificationsByempId) {
        // Display an alert if the input text is empty
        alert("Please enter a search term.");
        return;
      }
    
      this.qualificationsServices.getEmployeeQualifications(this.qualificationsByempId).subscribe(
        (data: any) => {
          if (data.length === 0) {
            // Display an alert if no data is found
            alert("No matching data found.");
          } else {
            // Set the ListQualifications if data is found
            this.ListQualifications = data.map((qualification: any) => ({
              qualificationId: qualification.qualificationId,
              empId: qualification.employee.empId,
              firstName: qualification.employee.firstName,
              lastName: qualification.employee.lastName,
              position: qualification.position,
              requirements: qualification.requirements,
              dateIn: qualification.dateIn
            }));
          }
        },
        (error: any) => {
          // Handle error if the HTTP request fails or empId is not found
          alert("Error occurred while fetching data. Please try again later or check the entered employee ID.");
        }
      );
    }
    


    public updateQualification(qualificationId:any){
      this.router.navigate(['/update-qualifications',qualificationId]);
      }


      public deleteQualifications(qualificationId:any){
        console.log(qualificationId);
        this.qualificationsServices.deleteQualifications(qualificationId).subscribe(
          (data:any)=>{
            this.ListQualifications=data;
            alert("data deleted successfuly");
           this.router.navigate(['/qualifications']) ;
          }
        )
      }


}
