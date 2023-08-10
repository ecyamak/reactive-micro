import {inject, Injectable} from "@angular/core";
import {AbstractBaseService} from "./base/abstract.base.service";
import {BehaviorSubject, tap} from "rxjs";
import {Router} from "@angular/router";

@Injectable()
export class AuthService extends AbstractBaseService {

  authenticated: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  signin(credentials: any, callback: any) {
    return this.httpService.post('/auth/signin', credentials)
      .subscribe(response => {
        this.setSession(credentials, response)
        return callback && callback();
      });
  }

  signup(credentials: any, callback: any) {
    credentials.roles = ['ROLE_USER']
    return this.httpService.post('/auth/signup', credentials)
      .subscribe(response => {
        return callback && callback();
      });
  }

  logout(credentials: any, callback: any) {
    return this.httpService.post('/auth/logout', credentials)
      .subscribe(response => {
        this.clearSession();
        return callback && callback();
      });
  }

  verify(verificationCode: string) {
    return this.httpService.get('/auth/verify?verificationCode=' + verificationCode);
  }

  private setSession(credentials: any, response: any) {
    if (response['token']) {
      sessionStorage.setItem('username', credentials.username)
      sessionStorage.setItem('token', response['token']);
      this.authenticated.next(true);
    } else {
      this.clearSession();
    }
  }

  private clearSession() {
    sessionStorage.clear();
    this.authenticated.next(false);
  }

}

export const AUTHGUARD = () => {
  const router: Router = inject(Router);
  const authService: AuthService = inject(AuthService);
  return authService.authenticated.pipe(
    tap((value) => {
      return !value ? router.navigate(['/login']) : true;
    })
  );
}
