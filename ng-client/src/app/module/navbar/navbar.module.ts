import {NgModule} from "@angular/core";
import {NavbarComponent} from "./component/navbar.component";
import {NavbarRoutingModule} from "./navbar.routing.module";
import {SearchbarModule} from "../searchbar/searchbar.module";

@NgModule({
  declarations: [
    NavbarComponent
  ],
    imports: [
        NavbarRoutingModule,
        SearchbarModule
    ],
  exports: [
    NavbarComponent
  ],
  providers: []
})
export class NavbarModule {

}
