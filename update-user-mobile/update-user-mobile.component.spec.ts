import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUserMobileComponent } from './update-user-mobile.component';

describe('UpdateUserMobileComponent', () => {
  let component: UpdateUserMobileComponent;
  let fixture: ComponentFixture<UpdateUserMobileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateUserMobileComponent]
    });
    fixture = TestBed.createComponent(UpdateUserMobileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
