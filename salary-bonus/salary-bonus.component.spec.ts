import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaryBonusComponent } from './salary-bonus.component';

describe('SalaryBonusComponent', () => {
  let component: SalaryBonusComponent;
  let fixture: ComponentFixture<SalaryBonusComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SalaryBonusComponent]
    });
    fixture = TestBed.createComponent(SalaryBonusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
