import { Component, OnInit, Input } from '@angular/core';
import { Course } from '../shared/model';
import { ApiService } from '../shared/api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
 @Input() course: Course;

  constructor(
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

}
