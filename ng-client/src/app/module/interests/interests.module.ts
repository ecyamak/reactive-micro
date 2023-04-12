import {NgModule} from "@angular/core";
import {InterestsComponent} from "./component/interests.component";
import {InterestsRoutingModule} from "./interests.routing.module";

@NgModule({
  declarations: [
    InterestsComponent
  ],
  imports: [
    InterestsRoutingModule
  ],
  exports: [
    InterestsComponent
  ],
  providers: []
})
export class InterestsModule {

}
