import {NgModule} from "@angular/core";
import {SearchbarComponent} from "./component/searchbar.component";
import {SearchbarRoutingModule} from "./searchbar.routing.module";

@NgModule({
  declarations: [
    SearchbarComponent
  ],
  imports: [
    SearchbarRoutingModule
  ],
  exports: [
    SearchbarComponent
  ],
  providers: []
})
export class SearchbarModule {

}
