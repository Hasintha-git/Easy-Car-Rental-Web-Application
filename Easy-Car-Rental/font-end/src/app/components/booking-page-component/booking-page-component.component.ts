import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {CustomerDetailsAddPageComponentComponent} from "./customer-details-add-page-component/customer-details-add-page-component.component";
import {SharedServiceService} from "../../../service/shared-service.service";
import {CustomerServiceService} from "../../../service/customer-service.service";
import Swal from "sweetalert2";
import {RentedRequestServiceService} from "../../../service/rented-request-service.service";



export interface Tile {

  color: string;
  cols: number;
  rows: number;
  text: string;
}
baseurl:String;

@Component({
  selector: 'app-booking-page-component',
  templateUrl: './booking-page-component.component.html',
  styleUrls: ['./booking-page-component.component.scss'],

})
export class BookingPageComponentComponent implements OnInit {

  tiles: Tile[] = [
    {text: 'One', cols: 4, rows: 3.5, color: 'lightgreen'},
    {text: 'Two', cols: 1, rows: 1, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
    {text: 'Four', cols: 1, rows: 1, color: '#DDBDF1'},
  ];
  baseurl: any;
  carName:string;

  dailyPrice:any;
  monthPrice:any;
  customId: any;
  vehicleNumber: string;
  currentKmeteres: string;
  userName:string;
  currentData:Array<any>=[];
  selectDriverOption: any;
  selectRentMethod: any;
  selectDay: any;
  startDate: any;
  endDate: any;
  dailyOrMonth: any;
  tot: any;
  rentalReq: string | undefined ;

  constructor(public dialog: MatDialog,private sharedService:SharedServiceService,private customerService:CustomerServiceService,private rentedService:RentedRequestServiceService) {
    this.monthPrice=50000
    this.dailyPrice=2500
    this.customId=4
    this.vehicleNumber="55"
    this.carName="-"

    this.userName = this.sharedService.getUserName();
    this.customerService.findCustomer(this.userName).subscribe(data=>{
      // @ts-ignore
      this.currentData=data.data;
      if (this.currentData[0]==null) {
        this.dialog.open(CustomerDetailsAddPageComponentComponent,{
          panelClass: 'my-class',
          backdropClass: 'backdropBackground',

        });
      }else{
        console.log(this.currentData)
        console.log("aye ona ne")
        this.customId=this.currentData[0].customerId
      }
    },error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Submit UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })



     this.vehicleNumber=this.sharedService.getVehicleNum();
     this.currentKmeteres=this.sharedService.getCurrentKm();
     this.dailyPrice=this.sharedService.getDailyPrice();
     this.monthPrice=this.sharedService.getMonthPrice();
     this.carName=this.sharedService.getCarName();

  }

  ngOnInit(): void {
    this.baseurl= "https://cdn.pixabay.com/photo/2014/07/01/12/35/taxi-381233__340.jpg";

  }


  selectPrice() {
    if (this.selectRentMethod == "Day") {
      this.dailyOrMonth=this.selectRentMethod;
      let number = this.dailyPrice*this.selectDay;
      this.tot=number;
      console.log(number)
    }else{
      this.dailyOrMonth=this.selectRentMethod;
      let number1 = this.monthPrice*this.selectDay;
      this.tot=number1;
      console.log(number1)
    }
  }

  sendRentRequest() {
    this.rentalReq="1";
    let formData = new FormData();

    formData.append("rentReqId",this.rentalReq);
    formData.append("currentKm",this.currentKmeteres)
    formData.append("driverOrNot",this.selectDriverOption)
    formData.append("pickupDate",this.startDate)
    formData.append("rentDuration",this.dailyOrMonth)
    formData.append("returnDate",this.endDate)
    formData.append("vehicleNum",this.vehicleNumber)
    formData.append("customerId",this.customId)

    this.rentedService.sendRentedRequest(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
    },error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Submit UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })
  }
}
