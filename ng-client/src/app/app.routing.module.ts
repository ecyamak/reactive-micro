import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'signin',
  },
  {
    path: 'signin',
    loadChildren: () => import('./domain/auth/module/auth.module').then(m => m.AuthModule)
  },
  /*
  {
    path: 'signup',
    data: {
      id: 'signup'
    },
    loadChildren: () => import('./domain/auth/module/auth.module').then(m => m.AuthModule)
  },
   */
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
