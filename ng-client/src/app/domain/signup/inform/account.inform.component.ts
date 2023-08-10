import {Component, OnInit} from "@angular/core";
import {CommonFormModule} from "../../../common/form/common.form.module";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  standalone: true,
  selector: 'account-inform',
  template:
    '<form id="accountInform" [formGroup]="formGroup">' +
    '  <h4>Account Information</h4>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <div class="formgrid grid">' +
    '        <div class="field col-6 mb-0">' +
    '          <label for="username">Username</label>' +
    '        </div>' +
    '        <div class="field col-6 mb-0">' +
    '          <validation-message [control]="formGroup.controls[\'username\']"></validation-message>'+
    '        </div>' +
    '      </div>' +
    '<span class="p-input-icon-left w-full">' +
    '<i class="pi pi-user"></i>' +
    '      <input id="username" formControlName="username" pInputText pKeyFilter="alphanum" class="w-full p-inputtext">' +
    '</span>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <label for="email">E-mail</label>' +
    '      <input class="w-full" pInputText id="email" placeholder="you@example.com" disabled="true"/>' +
    '    </div>' +
    '  </div>' +
    '  <div class="formgrid grid">' +
    '    <div class="field col">' +
    '      <div class="formgrid grid">' +
    '        <div class="field col-6 mb-0">' +
    '          <label for="password">Password</label>' +
    '        </div>' +
    '        <div class="field col-6 mb-0">' +
    '          <validation-message [control]="formGroup.controls[\'password\']"></validation-message>'+
    '        </div>' +
    '      </div>' +
    '      <p-password id="password" [feedback]="true" [toggleMask]="true" formControlName="password" styleClass="w-full" inputStyleClass="w-full">' +
    '        <ng-template pTemplate="footer">' +
    '          <p-divider></p-divider>' +
    '          <p class="mt-2">Suggestions</p>' +
    '          <ul class="pl-2 ml-2 mt-0" style="line-height: 1.5">' +
    '            <li>At least one lowercase</li>' +
    '            <li>At least one uppercase</li>' +
    '            <li>At least one numeric</li>' +
    '            <li>Minimum 8 characters</li>' +
    '          </ul>' +
    '        </ng-template>' +
    '      </p-password>' +
    '    </div>' +
    '    <div class="field col">' +
    '      <div class="formgrid grid">' +
    '        <div class="field col-6 mb-0">' +
    '          <label for="confirmPassword">Confirm Password</label>' +
    '        </div>' +
    '        <div class="field col-6 mb-0">' +
    '          <validation-message [control]="formGroup.controls[\'confirmPassword\']"></validation-message>'+
    '        </div>' +
    '      </div>' +
    '      <p-password id="password" [feedback]="false" [toggleMask]="true" formControlName="confirmPassword" styleClass="w-full" inputStyleClass="w-full"/>' +
    '    </div>' +
    '  </div>' +
    '</form>',
  imports: [CommonFormModule]
})
export class AccountInformComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.formGroup = this.formBuilder.group({
      username: [null, Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(5), Validators.pattern('[a-zA-Z ]*')])],
      password: [null, Validators.compose([Validators.required, Validators.minLength(8)])],
      confirmPassword: [null, Validators.compose([Validators.required, Validators.minLength(8)])]
    })
  }

}
