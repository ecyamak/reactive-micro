import {HttpService} from "../http/http.service";
import {Injectable} from "@angular/core";

@Injectable()
export abstract class AbstractBaseService {

  authenticated: boolean = false;

  constructor(protected httpService: HttpService) {}

}
