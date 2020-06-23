import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from "./students/student.component";
import {CoursesComponent} from "./courses/courses.component";
import {StudentDetailsComponent} from './student-details/student-details.component'

const routes: Routes=[
  {path:'students', component:StudentComponent},
  {path:'details/:id', component:StudentDetailsComponent},

  {path:'courses', pathMatch:'full', component:CoursesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports :[RouterModule]
})
export class AppRoutingModule { }
