import {NgModule} from "@angular/core";
import {HomeComponent} from "./home.component";
import {HomeRoutingModule} from "./home.routing.module";
import {ProfileModule} from "../profile/profile.module";

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    HomeRoutingModule,
    ProfileModule,
  ],
  providers: [

  ]
})
export class HomeModule {

}
