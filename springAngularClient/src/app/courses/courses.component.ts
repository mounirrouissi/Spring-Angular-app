import { Component, OnInit } from '@angular/core';
import {ApiService} from "../shared/api.service";
import {Course} from "../shared/model";



@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses:Course[]=[];

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

  kill(course: Course) {
    if(confirm('do you want to delete this course ?')){
      this.apiService.killCourse(course.courseId).subscribe(
        res=>
        {
          let index = this.courses.indexOf(course);
          this.courses.splice(index,1);
          alert("course deleted successfully")
        },
        error=>{
           alert("error occured during deleting ")
        }
      )  }

  }


}
