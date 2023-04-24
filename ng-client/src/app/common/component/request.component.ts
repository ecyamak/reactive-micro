import {Component} from "@angular/core";

@Component({
  standalone: true,
  selector: 'request',
  template:
    '<div class="w3-card w3-round w3-white w3-center">' +
    '  <div class="w3-container">' +
    '    <p>Friend Request</p>' +
    '    <img src="../../../../assets/images/avatar.png" alt="Avatar" style="width:50%"><br>' +
    '    <span>Jane Doe</span>' +
    '    <div class="w3-row w3-opacity">' +
    '      <div class="w3-half">' +
    '        <button class="w3-button w3-block w3-green w3-section" title="Accept"><i class="fa fa-check"></i></button>' +
    '      </div>' +
    '      <div class="w3-half">' +
    '        <button class="w3-button w3-block w3-red w3-section" title="Decline"><i class="fa fa-remove"></i></button>' +
    '      </div>' +
    '    </div>' +
    '  </div>' +
    '</div>' +
    '<br>'
})
export class RequestComponent {

}
