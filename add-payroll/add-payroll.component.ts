import { Component } from '@angular/core';
import { PayrollService } from '../payroll.service';
import { Payrolls } from '../payroll';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-payroll',
  templateUrl: './add-payroll.component.html',
  styleUrls: ['./add-payroll.component.css']
})
export class AddPayrollComponent {

  
  constructor(private  payrollService: PayrollService,private router:Router) { }

  payroll = new Payrolls(0,0,0,0,new Date(),'',0); 

  onSubmit() {
    console.log(this.payroll);
    this.payrollService.addPayroll(this.payroll).subscribe(
      () => {
        alert('payroll added successfully');
        this.router.navigate(['/welcome']);
      },
      (error) => {
        console.log(error);
        alert('Failed to add payroll');
      }
    );
  }

}
