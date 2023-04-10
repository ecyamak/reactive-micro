import {NgModule} from "@angular/core";
import {AuthComponent} from "../component/auth.component";
import {AuthService} from "../service/auth.service";
import {FormsModule} from "@angular/forms";
import {AuthRoutingModule} from "./auth.routing.module";

@NgModule({
  declarations: [
    AuthComponent
  ],
  imports: [
    AuthRoutingModule,
    FormsModule
  ],
  providers: [
    AuthService
  ]
})
export class AuthModule {

}
