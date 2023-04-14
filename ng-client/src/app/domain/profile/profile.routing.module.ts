import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ProfileComponent} from "./profile.component";
import {AUTHGUARD} from "../domain.service";

const routes: Routes = [
  {
    path: '',
    component: ProfileComponent,
    canActivate: [AUTHGUARD]
  }
]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule {

}
