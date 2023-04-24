import {Component} from "@angular/core";
import {CommonFormModule} from "../../../common/form/common.form.module";

@Component({
  standalone: true,
  selector: 'personal-inform',
  template:
    '<div>' +
    '  <h4>Personal Information</h4>' +
    '  <div class="formgrid grid flex justify-content-center flex-wrap card-container">' +
    '    <div class="field flex align-items-center justify-content-center">' +
    '      <p-image id="profile" src="assets/images/avatar.png" alt="image" width="120"></p-image>' +
    '    </div>' +
    '  </div>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="firstname">Firstname</label>' +
    '      <input id="firstname" class="w-full" pInputText pKeyFilter="alpha"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="middlename">Middlename</label>' +
    '      <input id="middlename" class="w-full" pInputText pKeyFilter="alpha" placeholder="Optional" />' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="lastname">Lastname</label>' +
    '      <input id="lastname" class="w-full" pInputText pKeyFilter="alpha"/>' +
    '    </div>' +
    '  </div>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="birthdate">Birthdate</label>' +
    '      <p-calendar id="birthdate" styleClass="w-full" [showIcon]="true"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="gender">Gender</label>' +
    '      <p-dropdown id="gender" styleClass="w-full"/>' +
    '    </div>' +
    '  </div>' +
    '</div>',
  imports: [CommonFormModule]
})
export class PersonalInformComponent {

}
