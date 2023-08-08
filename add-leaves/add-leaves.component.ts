import { Component } from '@angular/core';
import { LeavesService } from '../leaves.service';
import { Leaves } from '../leaves';

@Component({
  selector: 'app-add-leaves',
  templateUrl: './add-leaves.component.html',
  styleUrls: ['./add-leaves.component.css']
})
export class AddLeavesComponent {


  constructor(private  leaveService: LeavesService) { }

  leave = new Leaves(0,' ', ''); // Create an instance of the Leaves class

  onSubmit() {
    console.log(this.leave);
    this.leaveService.addLeaves(this.leave).subscribe(
      () => {
        alert('Leave added successfully');
      },
      (error) => {
        console.log(error);
        alert('Failed to add leave');
      }
    );
  }

}
