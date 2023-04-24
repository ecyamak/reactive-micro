import {Component} from "@angular/core";
import {CommonFormModule} from "../../../common/form/common.form.module";

@Component({
  standalone: true,
  selector: 'address-inform',
  template:
    '<div>' +
    '  <h4>Address Information</h4>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="phone">Phone</label>' +
    '      <p-inputMask id="phone" mask="(5**)-***-****" placeholder="(5**)-***-****" styleClass="w-full"></p-inputMask>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="address">Address</label>' +
    '      <input class="w-full" pInputText id="address" placeholder="Optional"/>' +
    '    </div>' +
    '  </div>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <label for="country">Country</label>' +
    '      <p-dropdown id="country" styleClass="w-full"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="state">State</label>' +
    '      <p-dropdown id="state" styleClass="w-full"/>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="zipcode">Zipcode</label>' +
    '      <input class="w-full" pInputText id="zipcode"/>' +
    '    </div>' +
    '  </div>' +
    '</div>',
  imports: [CommonFormModule]
})
export class AddressInformComponent {

}
