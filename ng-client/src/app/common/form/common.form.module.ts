import {NgModule} from "@angular/core";
import {InputTextComponent} from "./component/input.text.component";
import {CalendarModule} from "primeng/calendar";
import {DropdownModule} from "primeng/dropdown";
import {ButtonModule} from "primeng/button";
import {InputMaskModule} from "primeng/inputmask";
import {PasswordModule} from "primeng/password";
import {ReactiveFormsModule} from "@angular/forms";
import {InputTextModule} from "primeng/inputtext";
import {DividerModule} from "primeng/divider";
import {KeyFilterModule} from "primeng/keyfilter";
import {PasswordComponent} from "./component/password.component";
import {StepsModule} from "primeng/steps";
import {ChipModule} from "primeng/chip";
import {ChipsModule} from "primeng/chips";
import {AvatarModule} from "primeng/avatar";
import {ImageModule} from "primeng/image";
import {FileUploadModule} from "primeng/fileupload";
import {CardModule} from "primeng/card";
import {ValidationMessage} from "../../utils/validation/validation.message";

@NgModule({
  imports: [
    ButtonModule,
    CalendarModule,
    DividerModule,
    DropdownModule,
    InputMaskModule,
    InputTextModule,
    KeyFilterModule,
    PasswordModule,
    StepsModule,
    ValidationMessage,
    InputTextComponent,
    PasswordComponent,
  ],
  exports: [
    AvatarModule,
    ButtonModule,
    CalendarModule,
    CardModule,
    ChipModule,
    ChipsModule,
    DividerModule,
    DropdownModule,
    FileUploadModule,
    ImageModule,
    InputMaskModule,
    InputTextModule,
    KeyFilterModule,
    PasswordModule,
    StepsModule,
    ReactiveFormsModule,
    ValidationMessage,
    InputTextComponent,
    PasswordComponent,
  ],
})
export class CommonFormModule {

}
