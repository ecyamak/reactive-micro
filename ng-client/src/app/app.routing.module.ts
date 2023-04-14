import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./domain/domain.module').then(m => m.DomainModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./domain/login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'page',
    loadChildren: () => import('./module/common/common.module').then(m => m.CommonModule)
  },
  {
    path: '**',
    redirectTo: 'page'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
