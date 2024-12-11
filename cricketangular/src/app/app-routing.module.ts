import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DisplayAllComponent } from './components/display-all/display-all.component';
import { UpdateComponent } from './components/update/update.component';
import { AddplayerComponent } from './components/addplayer/addplayer.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path:'displayAll',component:DisplayAllComponent},
  {path:'update',component:UpdateComponent},
  {path:'addplayer',component:AddplayerComponent},
  {path:'home',component:HomeComponent},
  {path:'',redirectTo:'/home',pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
