import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponentComponent} from "./components/home-page-component/home-page-component.component";
import {CarPageComponentComponent} from "./components/car-page-component/car-page-component.component";
import {RegistrationPageComponentComponent} from "./components/registration-page-component/registration-page-component.component";
import {AdminPageComponentComponent} from "./components/admin-page-component/admin-page-component.component";
import {ProfilePageComponentComponent} from "./components/profile-page-component/profile-page-component.component";
import {AllCarsPageComponentComponent} from "./components/car-page-component/all-cars-page-component/all-cars-page-component.component";
import {GeneralCarsPageComponentComponent} from "./components/car-page-component/general-cars-page-component/general-cars-page-component.component";
import {PremiumCarsPageComponentComponent} from "./components/car-page-component/premium-cars-page-component/premium-cars-page-component.component";
import {LuxuryCarsPageComponentComponent} from "./components/car-page-component/luxury-cars-page-component/luxury-cars-page-component.component";
import {LoginPageComponentComponent} from "./components/login-page-component/login-page-component.component";
import {SignInPageComponent} from "./components/login-page-component/sign-in-page/sign-in-page.component";
import {SignUpPageComponent} from "./components/login-page-component/sign-up-page/sign-up-page.component";
import {BookingPageComponentComponent} from "./components/booking-page-component/booking-page-component.component";
import {DashboardPageComponentComponent} from "./components/admin-page-component/dashboard-page-component/dashboard-page-component.component";
import {DriverManagePageComponentComponent} from "./components/admin-page-component/driver-manage-page-component/driver-manage-page-component.component";
import {RentalRequestManagePageComponentComponent} from "./components/admin-page-component/rental-request-manage-page-component/rental-request-manage-page-component.component";
import {ReturnManagePageComponentComponent} from "./components/admin-page-component/return-manage-page-component/return-manage-page-component.component";
import {RentedVehiclePageComponentComponent} from "./components/admin-page-component/rented-vehicle-page-component/rented-vehicle-page-component.component";
import {CarManagePageComponentComponent} from "./components/admin-page-component/car-manage-page-component/car-manage-page-component.component";
import {AdminProfilePageComponentComponent} from "./components/admin-page-component/admin-profile-page-component/admin-profile-page-component.component";
import {DriverViewPageComponentComponent} from "./components/admin-page-component/driver-view-page-component/driver-view-page-component.component";
import {CarAddPageComponentComponent} from "./components/admin-page-component/car-manage-page-component/car-add-page-component/car-add-page-component.component";
import {CarViewPageComponentComponent} from "./components/admin-page-component/car-view-page-component/car-view-page-component.component";

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomePageComponentComponent,children:[

      {path:'general-cars',component:GeneralCarsPageComponentComponent},
      {path:'premium-cars',component:PremiumCarsPageComponentComponent},
      {path:'luxury-cars',component:GeneralCarsPageComponentComponent},
    ]},

  {path:'cars',component:CarPageComponentComponent,children:[
      {path:'',redirectTo:'all-cars',pathMatch:'full'},
      {path:'all-cars',component:AllCarsPageComponentComponent,children:[
          {path:'register',component:RegistrationPageComponentComponent},
        ]},
      {path:'general-cars',component:GeneralCarsPageComponentComponent,children:[
          {path:'register',component:RegistrationPageComponentComponent},
        ]},
      {path:'premium-cars',component:PremiumCarsPageComponentComponent,children:[
          {path:'register',component:RegistrationPageComponentComponent},
        ]},
      {path:'luxury-cars',component:LuxuryCarsPageComponentComponent,children:[
          {path:'register',component:RegistrationPageComponentComponent},
        ]},

    ]},
    //   {path:'',redirectTo:'signin',pathMatch:'full'},
    //   {path:'signin',component:SignInPageComponent,children:[
    //       {path:'bookingcar',component:CarPageComponentComponent},
    //     ]},
    //   {path:'signup',component:SignUpPageComponent},
    //
    // ]},
  {path:'register',component:RegistrationPageComponentComponent,children:[
      {path:'',redirectTo:'signin',pathMatch:'full'},
      {path:'signin',component:SignInPageComponent},
      {path:'signup',component:SignUpPageComponent},
    ]},
  {path:'booking',component:BookingPageComponentComponent},
  {path:'admin',component:AdminPageComponentComponent,children:[
      {path:'',redirectTo:'dashboard',pathMatch:'full'},
      {path:'dashboard',component:DashboardPageComponentComponent},
      {path:'carsmanage',component:CarViewPageComponentComponent},
      {path:'drivesmanage',component:DriverViewPageComponentComponent},
      {path:'rentalreq',component:RentalRequestManagePageComponentComponent},
      {path:'returnvehicle',component:ReturnManagePageComponentComponent},
      {path:'rentedvehicle',component:RentedVehiclePageComponentComponent},
      {path:'adminprofile',component:AdminProfilePageComponentComponent},
      {path:'driver',component:DriverViewPageComponentComponent},


    ]},
  {path:'driver',component:DriverViewPageComponentComponent},
  {path:'profile',component:LoginPageComponentComponent,children:[
      {path:'',redirectTo:'signin',pathMatch:'full'},
      {path:'signin',component:SignInPageComponent,children: [
          {path:'',redirectTo:'booking',pathMatch:'full'},
          {path:'booking',component:BookingPageComponentComponent},
          {path:'admin',component:AdminPageComponentComponent},

        ]},
      {path:'signup',component:SignUpPageComponent},
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
