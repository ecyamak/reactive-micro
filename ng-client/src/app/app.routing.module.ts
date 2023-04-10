import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'signup',
    data: {
      id: 'signup'
    },
    loadChildren: () => import('./domain/auth/module/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'login',
    data: {
      id: 'login'
    },
    loadChildren: () => import('./domain/auth/module/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./domain/home/module/home.module').then(m => m.HomeModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
