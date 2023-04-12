import {NgModule} from "@angular/core";
import {ShareComponent} from "./component/share.component";
import {ShareRoutingModule} from "./share.routing.module";

@NgModule({
  declarations: [
    ShareComponent
  ],
  imports: [
    ShareRoutingModule
  ],
  exports: [
    ShareComponent
  ],
  providers: []
})
export class ShareModule {

}
