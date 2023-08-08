import { Component, OnInit } from '@angular/core';
import { PayrollService } from '../payroll.service';
import { Router } from '@angular/router';
import { SalaryBonus } from '../salary-bonus';

@Component({
  selector: 'app-payroll',
  templateUrl: './payroll.component.html',
  styleUrls: ['./payroll.component.css']
})
export class PayrollComponent implements OnInit{

    ListPayroll:any;

    PayrollByempId:any;

  constructor(private payrollService: PayrollService, private router : Router){}

  public ngOnInit(): void {
   this.getAllPayroll();
  }

    public getAllPayroll(){
      this.payrollService.getAllPayroll().subscribe(
        (data: any) => {
  
          this.ListPayroll = data.map((payroll: any) => ({
            payrollId: payroll.payrollId,
            empId:payroll.employee.empId,
            firstName: payroll.employee.firstName,
            lastName: payroll.employee.lastName,
            jobId: payroll.jobDepartment.jobId,
            salaryId:payroll.salaryBonusEntity.salaryId,
            leave_ID:payroll.leaveentity.leave_ID,
            date:payroll.date,
            report:payroll.report,
            totalAmount:payroll.totalAmount,

          }));
        }
      );
    }


    public searchEmployee() {
      console.log(this.PayrollByempId);
    
      if (!this.PayrollByempId) {
        // Display an alert if the input text is empty
        alert("Please enter a search term.");
        return;
      }
    
      this.payrollService.getEmployeePayrolls(this.PayrollByempId).subscribe(
        (data: any) => {
          if (data.length === 0) {
            // Display an alert if no data is found
            alert("No matching data found.");
          } else {
            // Set the ListQualifications if data is found
           
            this.ListPayroll = data.map((payroll: any) => ({
              payrollId: payroll.payrollId,
              empId:payroll.employee.empId,
              firstName: payroll.employee.firstName,
              lastName: payroll.employee.lastName,
              jobId: payroll.jobDepartment.jobId,
              salaryId:payroll.salaryBonusEntity.salaryId,
              leave_ID:payroll.leaveentity.leave_ID,
              date:payroll.date,
              report:payroll.report,
              totalAmount:payroll.totalAmount,
  
            }));


          }
        },
        (error: any) => {
          // Handle error if the HTTP request fails or empId is not found
          alert("Error occurred while fetching data. Please try again later or check the entered employee ID.");
        }
      );
    }

    

    public updatePayroll(payrollId:any){
      this.router.navigate(['/update-payroll',payrollId]);
      }

      public deletePayroll(payrollId:any){
        console.log(payrollId);
        this.payrollService.deleteSPayroll(payrollId).subscribe(
          (data:any)=>{
            this.ListPayroll=data;
            alert("data deleted successfuly");
           this.router.navigate(['/payroll']) ;
          }
        )
      }

      showDetailedReport(payrollId: number) {
        this.router.navigate(['/payroll-detail', payrollId]);
      }


}
