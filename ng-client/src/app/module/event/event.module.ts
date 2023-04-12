import {NgModule} from "@angular/core";
import {EventComponent} from "./component/event.component";
import {EventRoutingModule} from "./event.routing.module";

@NgModule({
  declarations: [
    EventComponent
  ],
  imports: [
    EventRoutingModule
  ],
  exports: [
    EventComponent
  ],
  providers: []
})
export class EventModule {

}
