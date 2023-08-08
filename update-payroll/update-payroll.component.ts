import { Component, OnInit } from '@angular/core';
import { Payrolls } from '../payroll';
import { PayrollService } from '../payroll.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-payroll',
  templateUrl: './update-payroll.component.html',
  styleUrls: ['./update-payroll.component.css']
})
export class UpdatePayrollComponent implements OnInit{



  payrollId: any;
  payroll = new Payrolls(0,0,0,0,new Date(),'',0);

  constructor(private payrollService: PayrollService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.payrollId = this.activatedRoute.snapshot.params['payrollId'];
    this.payrollService.getPayrollById(this.payrollId).subscribe(
      (data: any) => {
        this.payroll = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }



  onSubmit() {
    this.payrollService.updatePayroll(this.payrollId, this.payroll).subscribe(
      (data: any) => {
        alert('payroll updated successfully');
        this.router.navigate(['/payroll']);
      }
    );
  }

}
