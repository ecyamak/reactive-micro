import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {DomainComponent} from "./domain.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: '',
    component: DomainComponent,
    children: [
      {
        path: 'home',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
      {
        path: 'profile',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
      {
        path: 'messages',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
      {
        path: 'search',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
      {
        path: 'settings',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DomainRoutingModule {

}
