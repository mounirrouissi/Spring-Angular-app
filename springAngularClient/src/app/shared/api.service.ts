import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Course, Student} from './model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {



  /** GET course by id. Will 404 if id not found */
  getCourse(id: number): Observable<Course> {
    return this.http.get<Course>(this.url+'/courses/'+id);
  }
  getStudent(id: number): Observable<Student> {
    return this.http.get<Student>(this.url+'/students/'+id);
  }

private url: String='http://localhost:8083';
constructor(private http: HttpClient) {
}

getAllStudents():Observable<Student[]>{
return  this.http.get<Student[]>(this.url + '/students');
}

getAllCourses():Observable<Course[]>{
    return  this.http.get<Course[]>(this.url + '/courses');
  }

  killStudent(id: number):Observable<any>{
  return this.http.delete<any>(this.url+'/students/'+id+'/delete');
  }

  addStudent(student: Student):Observable<Student> {
    return  this.http.post<Student>(this.url+'/students'+'/add',student);

  }

  reload():Observable<any> {
    return this.http.get(this.url+'/registration');
  }

  killCourse(courseId: number):Observable<any> {
    return this.http.delete<any>(this.url+"/courses/"+courseId+'/delete')
  }

  addCourse(course: Course):Observable<Course> {
    return this.http.post<Course>(this.url+'/courses/add',course);
  }

UpdateCourse(course: Course) {
    return this.http.put(this.url+'/courses/'+course.courseId+'/update',course,{responseType:'text' as 'json'});
  }
 UpdateStudent(student:Student)
 {
   return this.http.put(this.url+"/students/"+student.id+"/update",student);
 }
}
