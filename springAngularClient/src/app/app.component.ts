import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { Student, signIn } from './shared/model';
import { ApiService } from './shared/api.service';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { bindCallback } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'springAngularClient';
  student:Student=new Student();
  message: string='';
  signInPayload:signIn;
  Router: Router;
  loginForm:FormGroup;
  constructor(private apiService:ApiService,fb :FormBuilder) {
    this.loginForm=fb.group({
username:new FormControl("", Validators.required),
password:new FormControl("", Validators.required)
    });
    this.signInPayload={
      username:'',
      password:''
    }
  }

  ngOnInit(): void {
  }

  public onSubmit(){
      this.signInPayload.username=this.loginForm.get('username').value;
      this.signInPayload.password=this.loginForm.get('password').value;

    this.apiService.login(this.signInPayload).subscribe(
      async res=>{
          this.message="sign in successfully ";
           this.Router.navigateByUrl("/main")
            },
              error => {
                alert("error  occured");
              }
            );






    }
  }
