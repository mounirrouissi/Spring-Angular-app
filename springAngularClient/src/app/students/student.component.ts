import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ApiService} from '../shared/api.service';
import {Student} from "../shared/model";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {
  students:Student[]=[];
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getAll();
  }


getAll(){
  this.apiService.getAll().subscribe(
    res=>{
this.students=res;
console.log("it works")
  },
    error => {
      alert("error  occured");
    }
  );
  }
}
