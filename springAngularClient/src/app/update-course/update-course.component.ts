import { Component, OnInit } from '@angular/core';
import {Course} from "../shared/model";
import {ApiService} from "../shared/api.service";
@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.sass']
})
export class UpdateCourseComponent implements OnInit{
course:Course;
message:String='Update Course';
constructor(private apiService:ApiService) { }

  ngOnInit(): void {
  }
 UpdateCourse() {
    this.apiService.UpdateCourse(this.course).subscribe()
  }
}
