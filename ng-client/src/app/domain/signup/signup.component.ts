import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: 'signup.component.html'
})
export class SignupComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.formGroup = this.formBuilder.group({
      username: '',
      password: '',
      email: '',
      birthdate: '',
      university: '',
      faculty: '',
      department: '',
      year: ''
    })
  }

  submit() {
    console.log('submitted');
    console.log(this.formGroup);
  }

}
