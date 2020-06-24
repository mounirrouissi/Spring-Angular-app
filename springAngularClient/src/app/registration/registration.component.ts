import { Component, OnInit } from '@angular/core';
import {Student} from "../shared/model";
import {ApiService} from "../shared/api.service";

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
  public registerNow(){
    let resp=this.studentService.doRegistration(this.student);
    resp.subscribe((data)=>this.message=data);
  }
}
