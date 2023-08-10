import {HttpService} from "../http.service";
import {Injectable} from "@angular/core";

@Injectable()
export abstract class AbstractBaseService {

  constructor(protected httpService: HttpService) {}

}
