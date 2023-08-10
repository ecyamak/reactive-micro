import {Component, Input, OnInit} from "@angular/core";

@Component({
  standalone: true,
  selector: 'info-page',
  template: '<h2>{{message}}</h2>'
})
export class InfoPageComponent implements OnInit {

  @Input() type: string;
  message: string;

  ngOnInit(): void {
    this.message = this.getMessage(this.type);
  }

  getMessage(key: string) {
    switch (key) {
      case '200':
        return 'Success';
      case '401':
        return 'Unauthorized';
      case '404':
        return 'Not Found';
      case '503':
        return 'Unavailable';
      default:
        return 'Not Found'
    }
  }

}
