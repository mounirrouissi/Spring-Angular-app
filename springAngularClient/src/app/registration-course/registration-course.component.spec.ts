import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationCourseComponent } from './registration-course.component';

describe('RegistrationCourseComponent', () => {
  let component: RegistrationCourseComponent;
  let fixture: ComponentFixture<RegistrationCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
