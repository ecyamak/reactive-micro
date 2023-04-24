import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: 'not-found',
    loadComponent: () => import('./component/not.found.component').then(c => c.NotFoundComponent)
  },
  {
    path: 'not-available',
    loadComponent: () => import('./component/not.available.component').then(c => c.NotAvailableComponent)
  },
  {
    path: 'unauthorized',
    loadComponent: () => import('./component/unauthorized.component').then(c => c.UnauthorizedComponent)
  },
  {
    path: '**',
    redirectTo: 'not-found'
  },
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CommonErrorRoutingModule {

}
