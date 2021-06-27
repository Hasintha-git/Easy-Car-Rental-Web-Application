import { Component, OnInit } from '@angular/core';
import {BookingServiceService} from "../../../../service/booking-service.service";
import {CarServiceService} from "../../../../service/car-service.service";
import {PayServiceService} from "../../../../service/pay-service.service";
import Swal from "sweetalert2";


@Component({
  selector: 'app-return-manage-page-component',
  templateUrl: './return-manage-page-component.component.html',
  styleUrls: ['./return-manage-page-component.component.scss']
})
export class ReturnManagePageComponentComponent implements OnInit {
  currentData:Array<any>=[];
  Date: any;

  constructor(private bookingService:BookingServiceService,private carService:CarServiceService,private payService:PayServiceService) { }

  ngOnInit(): void {
    this.loadVehicle();
    let date = new Date();
    let s = date.toLocaleDateString();
    this.Date=s;
  }

  loadVehicle() {
    this.bookingService.getBooking().subscribe(data=>{
      this.currentData=data.data;
    })
  }

  vehicleNum:any;
  currentKM: any;
  rentFee: any;
  durationDays: any;
  monthOrDayPrice: any;
  monthOrDay: any;
  afterReturKm: any;
  freeKm: any;
  extraKm: any;
  extraKmFee: any;
  finalTot: any;
  rentDuration: any;

  betweenKm:any;
  extraKmPriceAdd:any;

  clickTblRow(row:any) {
    this.vehicleNum=row.car.vehicleNum;
    this.carService.findCar(this.vehicleNum).subscribe(data=>{
      console.log(data)
      console.log(data.data[0].monthPrice);
      if(row.rentDuration==="Month"){
        this.monthOrDay="Month"
        this.monthOrDayPrice=data.data[0].monthPrice
        this.currentKM=data.data[0].currentKm
        this.freeKm=data.data[0].kmForMonth;
        this.extraKmFee=data.data[0].priceForKm;
    }else{
        this.monthOrDay="Day"
        this.monthOrDayPrice=data.data[0].dailyPrice;
        this.currentKM=data.data[0].currentKm
        this.freeKm=data.data[0].kmForDay;
        this.extraKmFee=data.data[0].priceForKm;

      }


    })
  }

  rentPrice(rentDuration: any) {
    console.log(rentDuration,this.monthOrDayPrice)
    this.rentFee=this.rentDuration*this.monthOrDayPrice;
  }


  returnKm(afterReturKm: any) {
    this.afterReturKm=afterReturKm;
    console.log(afterReturKm)
    this.betweenKm=this.afterReturKm-this.currentKM;
    if (this.betweenKm > this.freeKm) {
      this.extraKm=this.betweenKm-this.freeKm;
      this.extraKmPriceAdd=this.extraKmFee*this.extraKm;
      this.finalTot=this.rentFee+this.extraKmPriceAdd;
    }else{
      this.extraKm=0;
      this.extraKmPriceAdd=0;
      this.finalTot=this.rentFee;
    }
  }
  payId:any;
  payBtn() {
    this.payId=1;
    let formData = new FormData();
    formData.append("payId",this.payId);
    formData.append("date",this.Date);
    formData.append("price",this.finalTot)

    this.payService.addPay(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Pay Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Pay UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })

  }
}
