import {Component} from "@angular/core";

@Component({
  standalone: true,
  selector: 'alert',
  template:
    '<div class="w3-container w3-display-container w3-round ecy-theme-light-blue w3-border w3-theme-border w3-margin-bottom w3-hide-small">' +
    '        <span onclick="this.parentElement.style.display=\'none\'" class="w3-button w3-theme-l3 w3-display-topright">' +
    '          <i class="fa fa-remove"></i>' +
    '        </span>' +
    '  <p><strong>Hey!</strong></p>' +
    '  <p>People are looking at your profile. Find out who.</p>' +
    '</div>' +
    '<br>'
})
export class AlertComponent {

}
