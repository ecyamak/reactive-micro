import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home.component";
import {AUTHGUARD} from "../../common/service/auth.service";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AUTHGUARD]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {

}
