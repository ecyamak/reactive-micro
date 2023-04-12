import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {BugComponent} from "./component/bug.component";

const routes: Routes = [
  {
    path: '',
    component: BugComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BugRoutingModule {

}
