import {Injectable} from "@angular/core";
import {AbstractBaseService} from "../../../common/base/abstract.base.service";

@Injectable()
export class AuthService extends AbstractBaseService {

  signup(credentials: any, callback: any) {
    credentials.roles = ['ROLE_USER']
    return this.httpService.post('/signup', credentials)
      .subscribe(response => {
        return callback && callback();
      });
  }

  login(credentials: any, callback: any) {
    return this.httpService.post('/login', credentials)
      .subscribe(response => {
        if (response['token']) {
          sessionStorage.setItem('token', response['token']);
        } else {
          sessionStorage.removeItem('token');
        }
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
