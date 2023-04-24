import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-signup',
  templateUrl: 'signup.component.html'
})
export class SignupComponent implements OnInit {

  formGroup: FormGroup;
  step: number = 0;

  steps: MenuItem[] = [
    {
      label: 'Account'
    },
    {
      label: 'Education'
    },
    {
      label: 'Personal'
    },
    {
      label: 'Address'
    },
    {
      label: 'Interest'
    }
  ]

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.formGroup = this.formBuilder.group({
      accountInform: null,
      institutionInform: null,
      personalInform: null,
      addressInform: null,
      interestInform: null
    })
  }

  onNext(): void {
    this.step++;
  }

  onPrevious(): void {
    this.step--;
  }

  submit(): void {
    console.log('submitted');
    console.log(this.formGroup);
  }

}
