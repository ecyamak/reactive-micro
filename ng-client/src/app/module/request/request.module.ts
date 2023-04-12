import {NgModule} from "@angular/core";
import {RequestComponent} from "./component/request.component";
import {RequestRoutingModule} from "./request.routing.module";

@NgModule({
  declarations: [
    RequestComponent
  ],
  imports: [
    RequestRoutingModule
  ],
  exports: [
    RequestComponent
  ],
  providers: []
})
export class RequestModule {

}
