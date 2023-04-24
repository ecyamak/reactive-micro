import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {CommonComponentModule} from "./common.component.module";
import {CommonFormModule} from "./form/common.form.module";

@NgModule({
  imports: [
    CommonModule,
    CommonComponentModule,
    CommonFormModule
  ],
  exports: [
    CommonModule,
    CommonComponentModule,
    CommonFormModule
  ]
})
export class CommonSharedModule {

}
