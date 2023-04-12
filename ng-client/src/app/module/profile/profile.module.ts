import {NgModule} from "@angular/core";
import {ProfileComponent} from "./component/profile.component";
import {ProfileRoutingModule} from "./profile.routing.module";

@NgModule({
  declarations: [
    ProfileComponent
  ],
  imports: [
    ProfileRoutingModule
  ],
  exports: [
    ProfileComponent
  ],
  providers: []
})
export class ProfileModule {

}
