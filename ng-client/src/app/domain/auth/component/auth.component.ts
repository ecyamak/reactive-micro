import {Component, ElementRef, ViewChild} from "@angular/core";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'auth',
  templateUrl: 'auth.component.html',
  styleUrls: ['auth.component.css']
})
export class AuthComponent {

  @ViewChild('container') container: ElementRef;

  credentials = {
    username: 'user',
    password: 'password',
    roles: null
  };

  sign: string = 'in';

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private authService: AuthService) {
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
        this.authService.signup(this.credentials, () => {
          this.router.navigateByUrl('/home');
        });
      }
    });
    return false;
  }

}
