import {NgModule} from "@angular/core";
import {ProfileComponent} from "./profile.component";
import {CommonSharedModule} from "../../common/common.shared.module";

@NgModule({
  declarations: [ProfileComponent],
  imports: [CommonSharedModule],
  exports: [ProfileComponent]
})
export class ProfileModule {

}
