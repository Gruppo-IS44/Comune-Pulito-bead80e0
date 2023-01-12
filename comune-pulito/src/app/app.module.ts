import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { SwitchComponent } from './login/switch-component/switch.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MappaComponent } from './mappa/mappa.component';
import { SegnalazioneComponent } from './segnalazione/segnalazione.component';
import { RewardComponent } from './reward/reward.component';
import { GestoreComponent } from './gestore/gestore.component';
import { InterceptorService } from './interceptor.service';

@NgModule({
  imports:      [ BrowserModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule ],
  declarations: [ AppComponent, LoginComponent, SwitchComponent, MappaComponent, SegnalazioneComponent, RewardComponent, GestoreComponent ],
  bootstrap:    [ AppComponent ],
  providers:    [ {provide:HTTP_INTERCEPTORS,useClass:InterceptorService, multi:true}]
})
export class AppModule { }