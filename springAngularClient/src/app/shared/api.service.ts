import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from './model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  Smodel: Student;
readonly url: 'http://localhost:8080/';
constructor(private http: HttpClient) {
}
insertStudent(Smodel: Student){
this.http.post(this.url + '/student', Smodel);
}
}
