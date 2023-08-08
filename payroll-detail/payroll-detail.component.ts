import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PayrollService } from '../payroll.service';


@Component({
  selector: 'app-payroll-detail',
  templateUrl: './payroll-detail.component.html',
  styleUrls: ['./payroll-detail.component.css']
})
export class PayrollDetailComponent implements OnInit {


  payrollData: any;

  constructor(private route: ActivatedRoute, private payrollService: PayrollService, private router: Router, private elementRef: ElementRef) {}

  ngOnInit(): void {
    // Get the payroll ID from the route parameter
    this.route.params.subscribe((params) => {
      const payrollId = params['id'];
      // Fetch the payroll detail using the payroll ID
      this.payrollService.getPayrollDetail(payrollId).subscribe((data: any) => {
        this.payrollData = data;
      });
    });
  }



  goBack(): void {
    this.router.navigate(['/payroll']);
  }

  
  printDetails(): void {
    window.print();
  }

}



