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

  killAllStudents(id: number):Observable<any>{
  return this.http.delete<any>(this.url+'/students/'+id);
  }

  addStudent(student: Student) {
    return  this.http.post(this.url+'/registrationStudent',student,{responseType:'text' as 'json'});

  }

  reload():Observable<any> {
    return this.http.get(this.url+'/registration');
  }

  killAllCourses(courseId: number):Observable<any> {
    return this.http.delete<any>(this.url+"/courses/"+courseId)
  }

  addCourse(course: Course) {
    return this.http.post(this.url+'/registrationCourse',course,{responseType:'text' as 'json'});
  }
}
