import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthComponent} from "./component/auth.component";

const routes: Routes = [
  {
    path: "",
    component: AuthComponent,
    children : [
      {
        path: "signup",
        loadChildren: () => import('../signup/signup.module').then(m => m.SignupModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule {

}
