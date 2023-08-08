import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateQualificationsComponent } from './update-qualifications.component';

describe('UpdateQualificationsComponent', () => {
  let component: UpdateQualificationsComponent;
  let fixture: ComponentFixture<UpdateQualificationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateQualificationsComponent]
    });
    fixture = TestBed.createComponent(UpdateQualificationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
