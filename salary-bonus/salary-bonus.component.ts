import { Component, OnInit } from '@angular/core';
import { SalaryBonusService } from '../salary-bonus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-salary-bonus',
  templateUrl: './salary-bonus.component.html',
  styleUrls: ['./salary-bonus.component.css']
})
export class SalaryBonusComponent implements OnInit{


  
  ListSalaryBonus:any;

  SalaryBonusByjobId:any;

  constructor(private salaryBonusService: SalaryBonusService, private router : Router){}

  public ngOnInit(): void {
   this.getAllSalaryBonus();
  }

    public getAllSalaryBonus(){
      this.salaryBonusService.getAllSalaryBonus().subscribe(
        (data: any) => {
  
          this.ListSalaryBonus = data.map((salarybonus: any) => ({
            salaryId: salarybonus.salaryId,
            jobId: salarybonus.jobDepartment.jobId,
            jobDepartments: salarybonus.jobDepartment.jobDepartments,
            jobName: salarybonus.jobDepartment.jobName,
            amount: salarybonus.amount,
            annualExpense: salarybonus.annualExpense,
            bonus:salarybonus.bonus
          }));
        }
      );
    }


    public searchEmployee() {
      console.log(this.SalaryBonusByjobId);
    
      if (!this.SalaryBonusByjobId) {
        // Display an alert if the input text is empty
        alert("Please enter a search term.");
        return;
      }
    
      this.salaryBonusService.getSalaryBonusesByJobDepartmentId(this.SalaryBonusByjobId).subscribe(
        (data: any) => {
          if (data.length === 0) {
            // Display an alert if no data is found
            alert("No matching data found.");
          } else {
            // Set the ListQualifications if data is found
           
            this.ListSalaryBonus = data.map((salarybonus: any) => ({
              salaryId: salarybonus.salaryId,
              jobId: salarybonus.jobDepartment.jobId,
              jobDepartments: salarybonus.jobDepartment.jobDepartments,
              jobName: salarybonus.jobDepartment.jobName,
              amount: salarybonus.amount,
              annualExpense: salarybonus.annualExpense,
              bonus:salarybonus.bonus
            }));

          }
        },
        (error: any) => {
          // Handle error if the HTTP request fails or empId is not found
          alert("Error occurred while fetching data. Please try again later or check the entered Job ID.");
        }
      );
    }




    public updateSalaryBonus(salaryId:any){
      this.router.navigate(['/update-salary-bonus',salaryId]);
      }

      public deleteSalaryBonus(salaryId:any){
        console.log(salaryId);
        this.salaryBonusService.deleteSalaryBonus(salaryId).subscribe(
          (data:any)=>{
            this.ListSalaryBonus=data;
            alert("data deleted successfuly");
           this.router.navigate(['/salary-bonus']) ;
          }
        )
      }


}
