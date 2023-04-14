import {inject, Injectable} from "@angular/core";
import {of, tap} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class DomainService {

  authenticated: boolean = true;

  isAvailable() {
    return of(this.authenticated).pipe(
      tap((v) => console.log(v))
    )
  }

}

export const AUTHGUARD = () => {
  const router: Router = inject(Router);
  const service: DomainService = inject(DomainService);
  return service.isAvailable().pipe(
    tap((value) => {
      return !value ? router.navigate(['/login']) : true;
    })
  );
}
