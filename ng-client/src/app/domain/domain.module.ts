import {NgModule} from "@angular/core";
import {DomainRoutingModule} from "./domain.routing.module";
import {DomainComponent} from "./domain.component";
import {NavbarModule} from "../module/navbar/navbar.module";
import {FooterModule} from "../module/footer/footer.module";

@NgModule({
  declarations: [DomainComponent],
  imports: [
    DomainRoutingModule,
    NavbarModule,
    FooterModule
  ],
  providers: []
})
export class DomainModule {

}
