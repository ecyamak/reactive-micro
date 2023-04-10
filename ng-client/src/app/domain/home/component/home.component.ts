import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {HomeService} from "../service/home.service";

@Component({
  selector: 'home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  title = 'Demo';
  greetings = {'id': null, 'content': null};

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private homeService: HomeService) {
  }

  ngOnInit(): void {
    this.homeService.resource().subscribe(data => this.greetings = data)
  }

  authenticated() {
    return false;
  }

}
