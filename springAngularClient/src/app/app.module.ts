import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './students/student.component';
import { CoursesComponent } from './courses/courses.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from "@angular/forms";
import {ApiService} from "./shared/api.service";
import { StudentDetailsComponent } from './student-details/student-details.component';
import { RegistrationComponent } from './registration/registration.component';
import { RegistrationCourseComponent } from './registration-course/registration-course.component';

import { CourseDetailComponent } from './course-detail/course-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    CoursesComponent,
    StudentDetailsComponent,
    RegistrationComponent,
    RegistrationCourseComponent,
    CourseDetailComponent

  ],
  imports: [
    BrowserModule,

    HttpClientModule,
    FormsModule,
    AppRoutingModule,
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
