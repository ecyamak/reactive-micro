import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {catchError, EMPTY, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = sessionStorage.getItem('token');
    if (token !== null) {
      req = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + token)
      })
    }
    return next.handle(req)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    sessionStorage.removeItem('token');
    return EMPTY;
  }

}
