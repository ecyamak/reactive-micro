import {NgModule} from "@angular/core";
import {IdentityComponent} from "./component/identity.component";
import {IdentityRoutingModule} from "./identity.routing.module";

@NgModule({
  declarations: [
    IdentityComponent
  ],
  imports: [
    IdentityRoutingModule
  ],
  exports: [
    IdentityComponent
  ],
  providers: []
})
export class IdentityModule {

}
