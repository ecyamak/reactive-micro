import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login.component";
import {VerificationComponent} from "./component/verification.component";

const routes: Routes = [
  {
    path: "",
    component: LoginComponent,
    children : [
      {
        path: "signup",
        loadChildren: () => import('../signup/signup.module').then(m => m.SignupModule)
      }
    ]
  },
  {
    path: 'verify/:verificationCode',
    component: VerificationComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule {

}
