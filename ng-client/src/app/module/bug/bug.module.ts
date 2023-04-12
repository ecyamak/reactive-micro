import {NgModule} from "@angular/core";
import {BugComponent} from "./component/bug.component";
import {BugRoutingModule} from "./bug.routing.module";
import {AdvertModule} from "../advert/advert.module";

@NgModule({
  declarations: [
    BugComponent
  ],
  imports: [
    BugRoutingModule,
    AdvertModule
  ],
  exports: [
    BugComponent
  ],
  providers: []
})
export class BugModule {

}
