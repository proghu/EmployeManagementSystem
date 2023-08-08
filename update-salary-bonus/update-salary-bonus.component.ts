import { Component, OnInit } from '@angular/core';
import { SalaryBonus } from '../salary-bonus';
import { SalaryBonusService } from '../salary-bonus.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-update-salary-bonus',
  templateUrl: './update-salary-bonus.component.html',
  styleUrls: ['./update-salary-bonus.component.css']
})
export class UpdateSalaryBonusComponent  implements OnInit{

  salaryId: any;
  salarybonus = new SalaryBonus(0,0, '','');

  constructor(private salarybonusService: SalaryBonusService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.salaryId = this.activatedRoute.snapshot.params['salaryId'];
    this.salarybonusService.getSalaryBonusById(this.salaryId).subscribe(
      (data: any) => {
        this.salarybonus = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }



  onSubmit() {
    this.salarybonusService.updateSalaryBonus(this.salaryId, this.salarybonus).subscribe(
      (data: any) => {
        alert('Qualification updated successfully');
        this.router.navigate(['/salary-bonus']);
      }
    );
  }


}
