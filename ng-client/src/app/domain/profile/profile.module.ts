import {NgModule} from "@angular/core";
import {ProfileComponent} from "./profile.component";
import {IdentityModule} from "../../module/identity/identity.module";
import {AccordionModule} from "../../module/accordion/accordion.module";
import {AlertModule} from "../../module/alert/alert.module";
import {ShareModule} from "../../module/share/share.module";
import {PostModule} from "../../module/post/post.module";
import {EventModule} from "../../module/event/event.module";
import {RequestModule} from "../../module/request/request.module";
import {AdvertModule} from "../../module/advert/advert.module";
import {BugModule} from "../../module/bug/bug.module";
import {InterestsModule} from "../../module/interests/interests.module";

@NgModule({
  declarations: [ProfileComponent],
  exports: [
    ProfileComponent
  ],
  imports: [
    IdentityModule,
    AccordionModule,
    AlertModule,
    ShareModule,
    PostModule,
    EventModule,
    RequestModule,
    AdvertModule,
    BugModule,
    InterestsModule,
  ]
})
export class ProfileModule {

}
