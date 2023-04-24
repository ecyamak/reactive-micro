import {Component} from "@angular/core";

@Component({
  standalone: true,
  selector: 'footer-module',
  template:
    '<footer class="w3-container ecy-theme-dark-blue w3-padding-16">' +
    '  <h5>Footer</h5>' +
    '</footer>' +
    '<footer class="w3-container ecy-theme-darker-blue">' +
    '  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>' +
    '</footer>'
})
export class FooterComponent {

}
