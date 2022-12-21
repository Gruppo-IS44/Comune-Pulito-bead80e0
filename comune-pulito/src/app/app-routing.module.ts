import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MappaComponent } from './mappa/mappa.component';
import { SegnalazioneComponent } from './segnalazione/segnalazione.component';
import { RewardComponent } from './reward/reward.component';

const routes:Routes=[
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'mappa', component:MappaComponent},
  {path:'segnalazione', component:SegnalazioneComponent},
  {path:'reward', component:RewardComponent}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
