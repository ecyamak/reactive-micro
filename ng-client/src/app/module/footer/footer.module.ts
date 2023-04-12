import {NgModule} from "@angular/core";
import {FooterComponent} from "./component/footer.component";
import {FooterRoutingModule} from "./footer.routing.module";

@NgModule({
  declarations: [
    FooterComponent
  ],
  imports: [
    FooterRoutingModule
  ],
  exports: [
    FooterComponent
  ],
  providers: []
})
export class FooterModule {

}
