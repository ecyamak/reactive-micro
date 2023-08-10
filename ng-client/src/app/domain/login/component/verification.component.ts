import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../common/service/auth.service";

@Component({
  selector: 'verification',
  template: '<h2>Please wait.</h2>'
})
export class VerificationComponent implements OnInit{

  verificationCode: string;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.verificationCode = params['verificationCode'];
    })
    this.authService.verify(this.verificationCode).subscribe(response => {
      if (response) this.router.navigateByUrl('/page/verified');
      else this.router.navigateByUrl('/page/unverified');
    });
  }



}
