import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {AbstractBaseService} from "../../../common/base/abstract.base.service";

@Injectable()
export class HomeService extends AbstractBaseService {

  resource(): Observable<any> {
    return this.httpService.get("/resource");
  }

}
