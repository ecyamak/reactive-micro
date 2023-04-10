import {Component} from "@angular/core";
import {AuthService} from "../service/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'auth',
  templateUrl: './auth.component.html'
})
export class AuthComponent {

  credentials = {
    username: 'user',
    password: 'password',
    roles: null
  };

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private authService: AuthService) {
  }

  authenticate() {
    this.activatedRoute.data.subscribe(data => {
      if (data['id'] === 'login') {
        this.authService.login(this.credentials, () => {
          this.router.navigateByUrl('/');
        });
      } else if (data['id'] === 'signup') {
        this.authService.signup(this.credentials, () => {
          this.router.navigateByUrl('/');
        });
      }
    });
    return false;
  }

}
