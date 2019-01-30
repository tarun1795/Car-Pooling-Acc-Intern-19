import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RidedetailsComponent } from './components/ridedetails/ridedetails.component';
import { RideslistComponent } from './components/rideslist/rideslist.component'
const routes: Routes = [
  {path: 'ride/all', component: RideslistComponent },
  {path: 'ride/:id', component: RidedetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [RidedetailsComponent, RideslistComponent];
