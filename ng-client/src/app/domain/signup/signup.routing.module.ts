import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {SignupComponent} from "./signup.component";
import {AUTHGUARD} from "../../common/service/auth.service";

const routes: Routes = [
  {
    path: '',
    component: SignupComponent,
    canActivate: [AUTHGUARD]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SignupRoutingModule {

}
