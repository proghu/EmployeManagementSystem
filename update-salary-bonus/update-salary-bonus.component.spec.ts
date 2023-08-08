import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSalaryBonusComponent } from './update-salary-bonus.component';

describe('UpdateSalaryBonusComponent', () => {
  let component: UpdateSalaryBonusComponent;
  let fixture: ComponentFixture<UpdateSalaryBonusComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateSalaryBonusComponent]
    });
    fixture = TestBed.createComponent(UpdateSalaryBonusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
