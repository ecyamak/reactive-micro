import {NgModule} from "@angular/core";
import {HomeComponent} from "../component/home.component";
import {HomeRoutingModule} from "./home.routing.module";
import {HomeService} from "../service/home.service";

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    HomeRoutingModule
  ],
  providers: [
    HomeService
  ]
})
export class HomeModule {

}
