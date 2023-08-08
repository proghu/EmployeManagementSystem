import { Component } from '@angular/core';
import { QualificationsService } from '../qualifications.service';
import { Qualifications } from '../qualifications';

@Component({
  selector: 'app-add-qualifications',
  templateUrl: './add-qualifications.component.html',
  styleUrls: ['./add-qualifications.component.css']
})
export class AddQualificationsComponent {


  constructor(private  qualificationsServices: QualificationsService) { }

  qualifications = new Qualifications(0,'', '',new Date()); 

  onSubmit() {
    console.log(this.qualifications);
    this.qualificationsServices.addQualification(this.qualifications).subscribe(
      () => {
        alert('Qualification added successfully');
      },
      (error) => {
        console.log(error);
        alert('Failed to add qualification');
      }
    );
  }


}
