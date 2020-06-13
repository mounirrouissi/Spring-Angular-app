import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ApiService} from '../shared/api.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.sass']
})
export class StudentComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.Smodel = {
      Id: null,
      firstName: '',
      lastName: ''

    };
    insertStudent();
  }

  onSubmit(form: NgForm) {
  }
  insertStudent(form: NgForm){
    this.apiService.insertStudent(form);
  }
}
