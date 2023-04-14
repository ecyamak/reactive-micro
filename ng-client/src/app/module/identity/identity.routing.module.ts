import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {IdentityComponent} from "./component/identity.component";

const routes: Routes = [
  {
    path: '',
    component: IdentityComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IdentityRoutingModule {

}
