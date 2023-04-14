import {Component, ElementRef, OnInit, ViewChild} from "@angular/core";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'auth',
  templateUrl: 'auth.component.html',
  styleUrls: ['auth.component.css']
})
export class AuthComponent implements OnInit{

  @ViewChild('container') container: ElementRef;

  credentials = {
    username: 'user',
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
      username: ['user', [Validators.required, Validators.minLength(4)]],
      password: ['password', [Validators.required, Validators.minLength(4)]]
    });
    this.signupForm = this.formBuilder.group({
      username1: ['user', [Validators.required, Validators.minLength(4)]],
      password1: ['password', [Validators.required, Validators.minLength(4)]]
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
        this.authService.signin(this.credentials, () => {
          this.router.navigateByUrl('/home');
        });
      } else {
        this.router.navigateByUrl('/signup');
        /*
        this.authService.signup(this.credentials, () => {
          this.router.navigateByUrl('/home');
        });
         */
      }
    });
    return false;
  }

}
