import {NgModule} from "@angular/core";
import {AlertComponent} from "./component/alert.component";
import {AlertRoutingModule} from "./alert.routing.module";
import {FooterModule} from "../footer/footer.module";

@NgModule({
  declarations: [
    AlertComponent
  ],
  imports: [
    AlertRoutingModule,
    FooterModule
  ],
  exports: [
    AlertComponent
  ],
  providers: []
})
export class AlertModule {

}
