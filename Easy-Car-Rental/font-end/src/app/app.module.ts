import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { HomePageComponentComponent } from './components/home-page-component/home-page-component.component';
import { CarPageComponentComponent } from './components/car-page-component/car-page-component.component';
import { RegistrationPageComponentComponent } from './components/registration-page-component/registration-page-component.component';
import { AdminPageComponentComponent } from './components/admin-page-component/admin-page-component.component';
import { ProfilePageComponentComponent } from './components/profile-page-component/profile-page-component.component';
import {MatButtonModule} from "@angular/material/button";
import { AllCarsPageComponentComponent } from './components/car-page-component/all-cars-page-component/all-cars-page-component.component';
import { GeneralCarsPageComponentComponent } from './components/car-page-component/general-cars-page-component/general-cars-page-component.component';
import { PremiumCarsPageComponentComponent } from './components/car-page-component/premium-cars-page-component/premium-cars-page-component.component';
import { LuxuryCarsPageComponentComponent } from './components/car-page-component/luxury-cars-page-component/luxury-cars-page-component.component';
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from '@angular/material/grid-list';
import { FooterPageComponentComponent } from './components/home-page-component/footer-page-component/footer-page-component.component';
import { LoginPageComponentComponent } from './components/login-page-component/login-page-component.component';
import {MatDialogModule} from '@angular/material/dialog';
import { SignInPageComponent } from './components/login-page-component/sign-in-page/sign-in-page.component';
import { SignUpPageComponent } from './components/login-page-component/sign-up-page/sign-up-page.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BookingPageComponentComponent } from './components/booking-page-component/booking-page-component.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from "@angular/material/select";
import {MatNativeDateModule} from "@angular/material/core";
import { NavbarPageComponentComponent } from './components/navbar-page-component/navbar-page-component.component';
import { DashboardPageComponentComponent } from './components/admin-page-component/dashboard-page-component/dashboard-page-component.component';
import { CarManagePageComponentComponent } from './components/admin-page-component/car-manage-page-component/car-manage-page-component.component';
import { DriverManagePageComponentComponent } from './components/admin-page-component/driver-manage-page-component/driver-manage-page-component.component';
import { RentalRequestManagePageComponentComponent } from './components/admin-page-component/rental-request-manage-page-component/rental-request-manage-page-component.component';
import { ReturnManagePageComponentComponent } from './components/admin-page-component/return-manage-page-component/return-manage-page-component.component';
import { RentedVehiclePageComponentComponent } from './components/admin-page-component/rented-vehicle-page-component/rented-vehicle-page-component.component';
import { AdminProfilePageComponentComponent } from './components/admin-page-component/admin-profile-page-component/admin-profile-page-component.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { DriverViewPageComponentComponent } from './components/admin-page-component/driver-view-page-component/driver-view-page-component.component';
import { NavPageComponentComponent } from './components/nav-page-component/nav-page-component.component';
import { CarViewPageComponentComponent } from './components/admin-page-component/car-view-page-component/car-view-page-component.component';
import { CarAddPageComponentComponent } from './components/admin-page-component/car-manage-page-component/car-add-page-component/car-add-page-component.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { CustomerDetailsAddPageComponentComponent } from './components/booking-page-component/customer-details-add-page-component/customer-details-add-page-component.component';
import { ChartsModule } from 'ng2-charts';


// noinspection AngularInvalidImportedOrDeclaredSymbol
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponentComponent,
    CarPageComponentComponent,
    RegistrationPageComponentComponent,
    AdminPageComponentComponent,
    ProfilePageComponentComponent,
    AllCarsPageComponentComponent,
    GeneralCarsPageComponentComponent,
    PremiumCarsPageComponentComponent,
    LuxuryCarsPageComponentComponent,
    FooterPageComponentComponent,
    LoginPageComponentComponent,
    SignInPageComponent,
    SignUpPageComponent,
    BookingPageComponentComponent,
    NavbarPageComponentComponent,
    DashboardPageComponentComponent,
    CarManagePageComponentComponent,
    DriverManagePageComponentComponent,
    RentalRequestManagePageComponentComponent,
    ReturnManagePageComponentComponent,
    RentedVehiclePageComponentComponent,
    AdminProfilePageComponentComponent,
    DriverViewPageComponentComponent,
    NavPageComponentComponent,
    CarViewPageComponentComponent,
    CarAddPageComponentComponent,
    CustomerDetailsAddPageComponentComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatGridListModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatSelectModule,
    MatNativeDateModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatTooltipModule,
    ChartsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
