import { Component, OnInit } from '@angular/core';
import {Student} from "../shared/model";
import {ApiService} from "../shared/api.service";
import {last} from "rxjs/operators";
import {Observable} from "rxjs";


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
student:Student=new Student();
  message:any;
  constructor(private studentService:ApiService) { }

  ngOnInit(): void {
  }
  public registerNow() {
    this.studentService.addStudent(this.student).subscribe(async (data)=>this.message="Registered successfully ");
    this.reloadData();
  }

  private reloadData() {
    this.student=new Student();
  }
}
