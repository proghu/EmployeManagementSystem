import { Component } from '@angular/core';
import { SalaryBonusService } from '../salary-bonus.service';
import { SalaryBonus } from '../salary-bonus';

@Component({
  selector: 'app-add-salary-bonus',
  templateUrl: './add-salary-bonus.component.html',
  styleUrls: ['./add-salary-bonus.component.css']
})
export class AddSalaryBonusComponent {

  
  constructor(private  salarrbonusService: SalaryBonusService) { }

  salarybonus = new SalaryBonus(0,0,'',''); 

  onSubmit() {
    console.log(this.salarybonus);
    this.salarrbonusService.addSalaryBonus(this.salarybonus).subscribe(
      () => {
        alert('salarybonus added successfully');
      },
      (error) => {
        console.log(error);
        alert('Failed to add salarybonus');
      }
    );
  }

}
