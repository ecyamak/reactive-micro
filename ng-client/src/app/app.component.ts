import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ng-client';

  constructor(private router: Router) {
  }

  logout() {
    this.router.navigateByUrl('/logout');
  }

}
