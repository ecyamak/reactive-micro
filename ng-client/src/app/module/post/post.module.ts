import {NgModule} from "@angular/core";
import {PostComponent} from "./component/post.component";
import {PostRoutingModule} from "./post.routing.module";

@NgModule({
  declarations: [
    PostComponent
  ],
  imports: [
    PostRoutingModule
  ],
  exports: [
    PostComponent
  ],
  providers: []
})
export class PostModule {

}
