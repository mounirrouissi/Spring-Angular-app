import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Course, Student} from './model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
private url: String='http://localhost:8080';
constructor(private http: HttpClient) {
}

getAllStudents():Observable<Student[]>{
return  this.http.get<Student[]>(this.url + '/students');
}
  getAllCourses():Observable<Course[]>{
    return  this.http.get<Course[]>(this.url + '/courses');
  }

  killAll(id: number):Observable<any>{
  return this.http.delete<any>(this.url+'/students/'+id);
  }

  doRegistration(student: Student) {
    return  this.http.post(this.url+'/registration',student,{responseType:'text' as 'json'});

  }
}
