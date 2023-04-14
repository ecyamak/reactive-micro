import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html'
})
export class ProfileComponent implements OnInit {

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
  }

  authenticated() {
    return false;
  }

}
