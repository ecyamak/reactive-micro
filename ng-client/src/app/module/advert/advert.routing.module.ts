import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AdvertComponent} from "./component/advert.component";

const routes: Routes = [
  {
    path: '',
    component: AdvertComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdvertRoutingModule {

}
