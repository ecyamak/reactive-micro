import {NgModule} from "@angular/core";
import {AuthComponent} from "./component/auth.component";
import {AuthService} from "./service/auth.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginRoutingModule} from "./login.routing.module";
import {ValidationMessage} from "../../utils/validation/validation.message";

@NgModule({
  declarations: [
    AuthComponent
  ],
  imports: [
    LoginRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ValidationMessage
  ],
  providers: [
    AuthService
  ]
})
export class LoginModule {

}
