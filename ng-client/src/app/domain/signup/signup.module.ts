import {NgModule} from "@angular/core";
import {SignupComponent} from "./signup.component";
import {SignupRoutingModule} from "./signup.routing.module";
import {CommonSharedModule} from "../../common/common.shared.module";
import {AccountInformComponent} from "./inform/account.inform.component";
import {PersonalInformComponent} from "./inform/personal.inform.component";
import {AddressInformComponent} from "./inform/address.inform.component";
import {InstitutionInformComponent} from "./inform/institution.inform.component";
import {InterestInformComponent} from "./inform/interest.inform.component";

@NgModule({
  declarations: [
    SignupComponent
  ],
  imports: [
    CommonSharedModule,
    SignupRoutingModule,
    AccountInformComponent,
    PersonalInformComponent,
    AddressInformComponent,
    InstitutionInformComponent,
    InterestInformComponent
  ],
  providers: [

  ]
})
export class SignupModule {

}
