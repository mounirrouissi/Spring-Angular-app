import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course, Student, signIn } from './model';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  login(signInPayload:signIn) {
return this.http.post<Student>(this.url+"/sign_in",signInPayload);
  }



  /** GET course by id. Will 404 if id not found */
  getCourse(id: number): Observable<Course> {
    return this.http.get<Course>(this.url + '/Courses/' + id);
  }
  getStudent(id: number): Observable<Student> {
    return this.http.get<Student>(this.url + '/students/' + id);
  }

  private url: String = 'http://localhost:8083';
  constructor(private http: HttpClient) {
  }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url + '/students');
  }

  getAllCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.url + '/Courses');
  }

  killStudent(id: number): Observable<any> {
    return this.http.delete<any>(this.url + '/students/' + id + '/delete');
  }

  addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(this.url + '/students', student);

  }

  reload(): Observable<any> {
    return this.http.get(this.url + '/registration');
  }

  killCourse(courseId: number): Observable<any> {
    return this.http.delete<any>(this.url + "/Courses/" + courseId + '/delete')
  }

  addCourse(course: Course): Observable<Course> {
    return this.http.post<Course>(this.url + '/Courses', course);
  }

  UpdateCourse(course: Course) {
    return this.http.put(this.url + '/Courses/' + course.courseId + '/update', course, { responseType: 'text' as 'json' });
  }
  UpdateStudent(student: Student) {
    return this.http.put(this.url + "/students/" + student.id + "/update", student);
  }
}
