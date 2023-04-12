import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app.routing.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpServiceInterceptor} from "./common/http/interceptor/http.service.interceptor";
import {NavbarModule} from "./module/navbar/navbar.module";
import {FooterModule} from "./module/footer/footer.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NavbarModule,
    FooterModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpServiceInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
