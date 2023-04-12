import {NgModule} from "@angular/core";
import {AdvertComponent} from "./component/advert.component";
import {AdvertRoutingModule} from "./advert.routing.module";

@NgModule({
  declarations: [
    AdvertComponent
  ],
  imports: [
    AdvertRoutingModule
  ],
  exports: [
    AdvertComponent
  ],
  providers: []
})
export class AdvertModule {

}
