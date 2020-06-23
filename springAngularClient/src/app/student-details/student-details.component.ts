import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ApiService} from "../shared/api.service";
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
    private StudentService: ApiService,
    private location: Location
  ) {}

  ngOnInit(): void {
   // this.getStudent();
  }

/*  getStudent(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.StudentService.getStudent(id)
      .subscribe(Student => this.Student = Student);
  }*/

  goBack(): void {
    this.location.back();
  }

/*  save(): void {
    this.StudentService.update(this.Student)
      .subscribe(() => this.goBack());
  }*/

}
