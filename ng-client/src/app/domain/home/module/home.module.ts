import {NgModule} from "@angular/core";
import {HomeComponent} from "../component/home.component";
import {HomeRoutingModule} from "./home.routing.module";
import {HomeService} from "../service/home.service";
import {ProfileModule} from "../../../module/profile/profile.module";
import {AccordionModule} from "../../../module/accordion/accordion.module";
import {AlertModule} from "../../../module/alert/alert.module";
import {ShareModule} from "../../../module/share/share.module";
import {PostModule} from "../../../module/post/post.module";
import {EventModule} from "../../../module/event/event.module";
import {RequestModule} from "../../../module/request/request.module";
import {AdvertModule} from "../../../module/advert/advert.module";
import {BugModule} from "../../../module/bug/bug.module";
import {InterestsModule} from "../../../module/interests/interests.module";
import {NavbarModule} from "../../../module/navbar/navbar.module";
import {FooterModule} from "../../../module/footer/footer.module";

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    HomeRoutingModule,
    ProfileModule,
    AccordionModule,
    AlertModule,
    ShareModule,
    PostModule,
    EventModule,
    RequestModule,
    AdvertModule,
    BugModule,
    InterestsModule,
    NavbarModule,
    FooterModule
  ],
  providers: [
    HomeService
  ]
})
export class HomeModule {

}
