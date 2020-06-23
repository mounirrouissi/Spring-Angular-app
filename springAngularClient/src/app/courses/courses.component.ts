import { Component, OnInit } from '@angular/core';
import {ApiService} from "../shared/api.service";
import {Course} from "../shared/model";



@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.sass']
})
export class CoursesComponent implements OnInit {
  courses:Course[]=[]
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getcourses();
  }
   getcourses() {
    this.apiService.getAllCourses().subscribe(
      res=>{
this.courses=res;
      }
    )

  }
}
