import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from './model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

private url: String='http://localhost:8080';
constructor(private http: HttpClient) {
}

getAll():Observable<Student[]>{
return  this.http.get<Student[]>(this.url + '/students');
}
}
