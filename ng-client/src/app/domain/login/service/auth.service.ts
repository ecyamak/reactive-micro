import {Injectable} from "@angular/core";
import {AbstractBaseService} from "../../../common/service/abstract.base.service";

@Injectable()
export class AuthService extends AbstractBaseService {

  signin(credentials: any, callback: any) {
    return this.httpService.post('/signin', credentials)
      .subscribe(response => {
        if (response['token']) {
          sessionStorage.setItem('token', response['token']);
        } else {
          sessionStorage.removeItem('token');
        }
        return callback && callback();
      });
  }

  signup(credentials: any, callback: any) {
    credentials.roles = ['ROLE_USER']
    return this.httpService.post('/signup', credentials)
      .subscribe(response => {
        return callback && callback();
      });
  }

  logout(credentials: any, callback: any) {
    sessionStorage.removeItem('token');
    return this.httpService.post('/logout', credentials)
      .subscribe(response => {
        return callback && callback();
      });
  }

}
