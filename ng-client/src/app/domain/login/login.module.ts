import {NgModule} from "@angular/core";
import {LoginComponent} from "./login.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginRoutingModule} from "./login.routing.module";
import {ValidationMessage} from "../../utils/validation/validation.message";
import {VerificationComponent} from "./component/verification.component";

@NgModule({
  declarations: [
    LoginComponent,
    VerificationComponent
  ],
  imports: [
    LoginRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ValidationMessage
  ],
  providers: []
})
export class LoginModule {

}
