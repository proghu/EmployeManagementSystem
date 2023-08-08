import { Component, OnInit } from '@angular/core';
import { Departments } from '../departments';
import { DepartmentsService } from '../departments.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-departments',
  templateUrl: './update-departments.component.html',
  styleUrls: ['./update-departments.component.css']
})
export class UpdateDepartmentsComponent implements OnInit {

  jobId: any;
  departments = new Departments('', '', '', '');

  constructor(private depatmentsService: DepartmentsService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.jobId = this.activatedRoute.snapshot.params['jobId'];
    this.depatmentsService.getDepartmentById(this.jobId).subscribe(
      (data: any) => {
        this.departments = data;
      }
    );
  }

  onSubmit() {
    this.depatmentsService.updateDepartment(this.jobId, this.departments).subscribe(
      (data: any) => {
        alert('Department updated successfully');
        this.router.navigate(['/departments']);
      }
    );
  }

}
