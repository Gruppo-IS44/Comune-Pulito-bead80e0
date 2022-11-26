import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { SwitchComponent } from './login/switch-component/switch.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  imports:      [ BrowserModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule ],
  declarations: [ AppComponent, LoginComponent, SwitchComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }