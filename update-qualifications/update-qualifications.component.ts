import { Component, OnInit } from '@angular/core';
import { Qualifications } from '../qualifications';
import { QualificationsService } from '../qualifications.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-qualifications',
  templateUrl: './update-qualifications.component.html',
  styleUrls: ['./update-qualifications.component.css']
})
export class UpdateQualificationsComponent implements OnInit {

  qualificationId: any;
  qualifications = new Qualifications(0, '', '',new Date());

  constructor(private qualificationsService: QualificationsService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.qualificationId = this.activatedRoute.snapshot.params['qualificationId'];
    this.qualificationsService.getQualificationById(this.qualificationId).subscribe(
      (data: any) => {
        this.qualifications = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }



  onSubmit() {
    this.qualificationsService.updateQualification(this.qualificationId, this.qualifications).subscribe(
      (data: any) => {
        alert('Qualification updated successfully');
        this.router.navigate(['/qualifications']);
      }
    );
  }
 

}
