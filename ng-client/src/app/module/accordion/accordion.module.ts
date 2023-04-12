import {NgModule} from "@angular/core";
import {AccordionComponent} from "./component/accordion.component";
import {AccordionRoutingModule} from "./accordion.routing.module";

@NgModule({
  declarations: [
    AccordionComponent
  ],
  imports: [
    AccordionRoutingModule
  ],
  exports: [
    AccordionComponent
  ],
  providers: []
})
export class AccordionModule {

}
