import {NgModule} from "@angular/core";
import {IdentityComponent} from "./component/identity.component";
import {AccordionComponent} from "./component/accordion.component";
import {AdvertComponent} from "./component/advert.component";
import {AlertComponent} from "./component/alert.component";
import {BugComponent} from "./component/bug.component";
import {EventComponent} from "./component/event.component";
import {FooterComponent} from "./component/footer.component";
import {InterestsComponent} from "./component/interests.component";
import {NavbarComponent} from "./component/navbar.component";
import {PostComponent} from "./component/post.component";
import {RequestComponent} from "./component/request.component";
import {SearchbarComponent} from "./component/searchbar.component";
import {ShareComponent} from "./component/share.component";

@NgModule({
  imports: [
    AccordionComponent,
    AdvertComponent,
    AlertComponent,
    BugComponent,
    EventComponent,
    FooterComponent,
    IdentityComponent,
    InterestsComponent,
    NavbarComponent,
    PostComponent,
    RequestComponent,
    SearchbarComponent,
    ShareComponent
  ],
  exports: [
    AccordionComponent,
    AdvertComponent,
    AlertComponent,
    BugComponent,
    EventComponent,
    IdentityComponent,
    InterestsComponent,
    NavbarComponent,
    PostComponent,
    RequestComponent,
    SearchbarComponent,
    ShareComponent
  ]
})
export class CommonComponentModule {

}
