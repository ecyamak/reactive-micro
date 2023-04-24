import {Component} from "@angular/core";

@Component({
  standalone: true,
  selector: 'accordion',
  template:
    '<div class="w3-card w3-round">' +
    '  <div class="w3-white ecy-theme-dark-blue">' +
    '    <button class="w3-button w3-block w3-left-align"><i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> My Groups</button>' +
    '    <div id="Demo1" class="w3-hide w3-container">' +
    '      <p>Some text..</p>' +
    '    </div>' +
    '    <button class="w3-button w3-block w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Events</button>' +
    '    <div id="Demo2" class="w3-hide w3-container">' +
    '      <p>Some other text..</p>' +
    '    </div>' +
    '    <button class="w3-button w3-block w3-left-align"><i class="fa fa-users fa-fw w3-margin-right"></i> My Photos</button>' +
    '    <div id="Demo3" class="w3-hide w3-container">' +
    '      <div class="w3-row-padding">' +
    '        <br>' +
    '        <div class="w3-half">' +
    '          <img src="../../../../assets/images/mountain.png" style="width:100%" class="w3-margin-bottom">' +
    '        </div>' +
    '      </div>' +
    '    </div>' +
    '  </div>' +
    '</div>' +
    '<br>'
})
export class AccordionComponent {

}
