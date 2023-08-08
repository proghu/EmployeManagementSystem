import { Component, OnInit } from '@angular/core';
import { Leaves } from '../leaves';
import { LeavesService } from '../leaves.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-leaves',
  templateUrl: './update-leaves.component.html',
  styleUrls: ['./update-leaves.component.css']
})
export class UpdateLeavesComponent implements OnInit {

 leave_ID: any;
  leave = new Leaves(0, '', '');

  constructor(private leaveService: LeavesService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.leave_ID = this.activatedRoute.snapshot.params['leave_ID'];
    this.leaveService.getLeaveById(this.leave_ID).subscribe(
      (data: any) => {
        this.leave = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }



  onSubmit() {
    this.leaveService.updateLeave(this.leave_ID, this.leave).subscribe(
      (data: any) => {
        alert('leave updated successfully');
        this.router.navigate(['/leaves']);
      }
    );
  }
 

}
