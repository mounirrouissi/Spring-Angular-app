import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ApiService} from '../shared/api.service';
import {Student} from "../shared/model";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students:Student[]=[];
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getAll();
  }


getAll(){
  this.apiService.getAllStudents().subscribe(
    res=>{
this.students=res;
console.log("it works")
  },
    error => {
      alert("error  occured");
    }
  );
  }

   kill(student:Student) {
    if(confirm('do you want to delete this student ?')){
    this.apiService.killAll(student.id).subscribe(
      res=>
      {
        let index = this.students.indexOf(student);
        this.students.splice(index,1);
alert("student deleted successfully")
      },
      error=>{
        alert("error occured during deleting ")
      }
    )  }

  }


}
