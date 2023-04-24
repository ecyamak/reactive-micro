import {Component} from "@angular/core";
import {CommonFormModule} from "../../../common/form/common.form.module";

@Component({
  standalone: true,
  selector: 'institution-inform',
  template:
    '<div>' +
    '  <h4>Institution Information</h4>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="institution">Institution</label>' +
    '      <p-dropdown id="institution" styleClass="w-full"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="faculty">Faculty</label>' +
    '      <p-dropdown id="faculty" styleClass="w-full"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="department">Department</label>' +
    '      <p-dropdown id="department" styleClass="w-full"/>' +
    '    </div>' +
    '  </div>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="degree">Degree</label>' +
    '      <input class="w-full" pInputText id="degree"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="entrance">Entrance</label>' +
    '      <p-calendar id="entrance" styleClass="w-full" [showIcon]="true"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="year">Year</label>' +
    '      <input class="w-full" pInputText id="year"/>' +
    '    </div>' +
    '  </div>' +
    '</div>',
  imports: [CommonFormModule]
})
export class InstitutionInformComponent {

}
