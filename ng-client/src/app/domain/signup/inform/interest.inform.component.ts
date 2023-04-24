import {Component} from "@angular/core";
import {CommonFormModule} from "../../../common/form/common.form.module";

@Component({
  standalone: true,
  selector: 'interest-inform',
  template:
    '<div>' +
    '  <h4>Interest Information</h4>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="hobbies">Hobbies</label>' +
    '      <p-chips id="hobbies" styleClass="block"/>' +
    '    </div>' +
    '  </div>' +
    '</div>',
  imports: [CommonFormModule]
})
export class InterestInformComponent {

}
