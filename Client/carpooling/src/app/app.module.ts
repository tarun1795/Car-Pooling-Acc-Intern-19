import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RideslistComponent } from './components/rideslist/rideslist.component';
import {
  MatCardModule,
  MatButtonModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import { RidesearchComponent } from './components/ridesearch/ridesearch.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { RidedetailsComponent } from './components/ridedetails/ridedetails.component';
@NgModule({
  declarations: [
    AppComponent,
    RideslistComponent,
    RidesearchComponent,
    RidedetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatButtonModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
