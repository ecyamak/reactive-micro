import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {AppRoutingModule} from "./app.routing.module";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpServiceInterceptor} from "./common/interceptor/http.service.interceptor";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AuthService} from "./common/service/auth.service";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [
    AuthService,
    {
      provide: HTTP_INTERCEPTORS, useClass: HttpServiceInterceptor, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
