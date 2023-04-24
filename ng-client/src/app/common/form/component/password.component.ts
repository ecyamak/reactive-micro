import {Component, Input} from "@angular/core";
import {PasswordModule} from "primeng/password";
import {DividerModule} from "primeng/divider";
import {AbstractControl, FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  standalone: true,
  selector: 'password',
  template:
    '<p-password id="{{id}}" [feedback]="feedback" [toggleMask]="true" formControlName="formControlName" styleClass="w-full" inputStyleClass="w-full" minlength="8">' +
    '  <ng-template pTemplate="footer">' +
    '    <p-divider></p-divider>' +
    '    <p class="mt-2">Suggestions</p>' +
    '    <ul class="pl-2 ml-2 mt-0" style="line-height: 1.5">' +
    '      <li>At least one lowercase</li>' +
    '      <li>At least one uppercase</li>' +
    '      <li>At least one numeric</li>' +
    '      <li>Minimum 8 characters</li>' +
    '    </ul>' +
    '  </ng-template>' +
    '</p-password>',
  imports: [PasswordModule, DividerModule, ReactiveFormsModule]
})
export class PasswordComponent {

  @Input() id: string;
  @Input() feedback: boolean = true;
  @Input() formGroup: FormGroup;
  @Input() formControlName: string;

}
