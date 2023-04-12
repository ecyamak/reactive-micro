import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ShareComponent} from "./component/share.component";

const routes: Routes = [
  {
    path: '',
    component: ShareComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShareRoutingModule {

}
