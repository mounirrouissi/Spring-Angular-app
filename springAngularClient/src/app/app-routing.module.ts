import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from "./students/student.component";
import {CoursesComponent} from "./courses/courses.component";
import {StudentDetailsComponent} from './student-details/student-details.component'
import {RegistrationComponent} from "./registration/registration.component";
import {RegistrationCourseComponent} from "./registration-course/registration-course.component";

const routes: Routes=[
  {path:'students', component:StudentComponent},
  {path:'details/:id', component:StudentDetailsComponent},

  {path:'courses', pathMatch:'full', component:CoursesComponent},
  {path:'registrationStudent', pathMatch:'full', component:RegistrationComponent},
  {path :'registrationCourse',component:RegistrationCourseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports :[RouterModule]
})
export class AppRoutingModule { }
