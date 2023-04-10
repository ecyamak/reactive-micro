import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app.routing.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpServiceInterceptor} from "./common/http/interceptor/http.service.interceptor";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpServiceInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
