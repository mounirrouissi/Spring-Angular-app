import { Component, OnInit } from '@angular/core';
import {Course} from "../shared/model";
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-registration-course',
  templateUrl: './registration-course.component.html',
  styleUrls: ['./registration-course.component.sass']
})
export class RegistrationCourseComponent implements OnInit {
  course:Course;
  message:String='WELCOME';
  constructor(private apiService:ApiService) { }

  ngOnInit() {
  }
  registerNow() {
    this.apiService.addCourse(this.course).subscribe()
  }
}
