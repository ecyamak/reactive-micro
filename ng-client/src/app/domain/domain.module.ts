import {NgModule} from "@angular/core";
import {DomainRoutingModule} from "./domain.routing.module";
import {DomainComponent} from "./domain.component";
import {FooterComponent} from "../common/component/footer.component";
import {NavbarComponent} from "../common/component/navbar.component";

@NgModule({
  declarations: [DomainComponent],
  imports: [
    DomainRoutingModule,
    FooterComponent,
    NavbarComponent
  ],
  providers: []
})
export class DomainModule {

}
