import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from "./students/student.component";
import {CoursesComponent} from "./courses/courses.component";
import {StudentDetailsComponent} from './student-details/student-details.component'
import {RegistrationComponent} from "./registration/registration.component";

const routes: Routes=[
  {path:'students', component:StudentComponent},
  {path:'details/:id', component:StudentDetailsComponent},

  {path:'courses', pathMatch:'full', component:CoursesComponent},
  {path:'registration', pathMatch:'full', component:RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports :[RouterModule]
})
export class AppRoutingModule { }
