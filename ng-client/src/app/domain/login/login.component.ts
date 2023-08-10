import {Component, ElementRef, OnInit, ViewChild} from "@angular/core";
import {AuthService} from "../../common/service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'login',
  templateUrl: 'login.component.html',
  styleUrls: ['login.component.css']
})
export class LoginComponent implements OnInit{

  @ViewChild('container') container: ElementRef;

  credentials = {
    username: 'admin',
    email: '',
    password: 'password',
    roles: null
  };

  signinForm: FormGroup;
  signupForm: FormGroup;

  sign: string = 'in';

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private authService: AuthService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.signinForm = this.formBuilder.group({
      username: [this.credentials.username, [Validators.required, Validators.minLength(4)]],
      password: [this.credentials.password, [Validators.required, Validators.minLength(4)]]
    });
    this.signupForm = this.formBuilder.group({
      email: ["ensarcanyamak@gmail.com", [Validators.required, Validators.minLength(4)]],
      password: ["password", [Validators.required, Validators.minLength(4)]]
    });
  }

  signin() {
    this.sign = 'in';
    this.container.nativeElement.classList.remove('right-panel-active')
  }

  signup() {
    this.sign = 'up';
    this.container.nativeElement.classList.add('right-panel-active')
  }

  authenticate() {
    this.activatedRoute.data.subscribe(data => {
      if (this.sign === 'in') {
        this.authService.signin(this.prepareData(this.signinForm), () => {
          this.router.navigateByUrl('/home');
        });
      } else {
        this.authService.signup(this.prepareData(this.signupForm), () => {
          this.router.navigateByUrl('/signup');
        });
      }
    });
    return false;
  }

  prepareData(form: FormGroup) {
    this.credentials.username = form.value.username;
    this.credentials.email = form.value.email;
    this.credentials.password = form.value.password;
    return this.credentials;
  }

}
