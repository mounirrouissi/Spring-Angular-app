import { ApiService } from './../shared/api.service';
import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Student} from "../shared/model";
import { Location } from '@angular/common';


@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  @Input() student: Student;

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getStudent();
  }

 getStudent(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.apiService.getStudent(id)
      .subscribe(Student => this.student = Student);
  }

  goBack(): void {
    this.location.back();
  }
 save(): void {
    this.apiService.UpdateStudent(this.student)
      .subscribe(() => this.goBack());
  }

}
