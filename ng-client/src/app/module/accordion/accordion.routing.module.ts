import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AccordionComponent} from "./component/accordion.component";

const routes: Routes = [
  {
    path: '',
    component: AccordionComponent
  }
]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccordionRoutingModule {

}
