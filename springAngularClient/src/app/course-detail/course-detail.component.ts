import { Component, OnInit, Input } from '@angular/core';
import { Course } from '../shared/model';
import { ApiService } from '../shared/api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { from } from 'rxjs';
@Component({
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
 @Input() course: Course;

  constructor(
    private rourter:Router,
    private location:Location,
    private route: ActivatedRoute,
    private apiService: ApiService
 ) {    }

  ngOnInit(): void {
    this.getCourse();
  }
  getCourse(): void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.apiService.getCourse(id)
      .subscribe(course => this.course = course);
  }
  goBack(): void {
    this.location.back();
  }
save(){
  this.apiService.UpdateCourse(this.course).subscribe(res=>console.log("success"),err=>console.log("errrr"));
  this.reload();
}
  reload() {
this.rourter.navigate(['/courses']) ; }
}
