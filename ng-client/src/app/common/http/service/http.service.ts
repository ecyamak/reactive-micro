import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  get(location: string, options?): Observable<any> {
    return this.http.get(this.url + location);
  }

  post(location: string, body: any | null, options?): Observable<any> {
    return this.http.post(this.url + location, body);
  }

  put(location: string, body: any | null, options?): Observable<any> {
    return this.http.put(this.url + location, body);
  }

  patch(location: string, body: any | null, options?): Observable<any> {
    return this.http.patch(this.url + location, body);
  }

  delete(location: string, options?): Observable<any> {
    return this.http.delete(this.url + location);
  }

}
