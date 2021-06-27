import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {RentedRequestServiceService} from "../../../../service/rented-request-service.service";
import {DriverViewPageComponentComponent} from "../driver-view-page-component/driver-view-page-component.component";
import {SharedServiceService} from "../../../../service/shared-service.service";
import {DriverServiceService} from "../../../../service/driver-service.service";
import Swal from "sweetalert2";
import {BookingServiceService} from "../../../../service/booking-service.service";

@Component({
  selector: 'app-rental-request-manage-page-component',
  templateUrl: './rental-request-manage-page-component.component.html',
  styleUrls: ['./rental-request-manage-page-component.component.scss']
})
export class RentalRequestManagePageComponentComponent implements OnInit {

  currentData:Array<any>=[];

  currentKM: any;

  rentReqId: any;

  pickupDate: any;

  returnDate: any;

  rentDuration: any;

  vehicleNum: any;

  driverOrNote: any;

  customerId: any;

  selectDriverOption: any;
  driversData:Array<any>=[];
  constructor(private bookingService:BookingServiceService,private driverService:DriverServiceService ,public dialog: MatDialog,private rentReqService:RentedRequestServiceService) {

  }

  ngOnInit(): void {
    this.loadRequest();
    this.getAllDrivers();
  }




  getAllDrivers(){
    this.driverService.getAllDrivers().subscribe(data=>{
      this.driversData=data.data;
    })
  }

  rentReqnewId:any;
  delete(row:any) {
   this.rentReqnewId=row.rentId;
    this.rentReqService.removeReq(this.rentReqnewId).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Submit Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      this.loadRequest()
      console.log(data)
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Submit UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    });
  }


  loadRequest() {
    this.rentReqService.getAllRequest().subscribe(data=>{
      this.currentData=data.data;
    })
  }


  reqTblClick(row: any) {
    this.currentKM=row.currentKM;
    this.pickupDate=row.pickupDate.toLocaleDateString();
    this.rentReqId=row.rentId;
    this.returnDate=row.returnDate.toLocaleDateString();
    this.driverOrNote=row.driverOrNot;
    this.rentDuration=row.rentDuration;
    this.customerId=row.customer.customerId;
    this.vehicleNum=row.car.vehicleNum;
  }


  bookingId:any;

  bookingSet() {


    this.bookingId=2;
    console.log(this.rentReqId)
    let formData = new FormData();

    formData.append("bookingId",this.bookingId)
    formData.append("rentReqId",this.rentReqId);
    formData.append("currentKm",this.currentKM);
    formData.append("driverOrNot",this.driverOrNote);
    formData.append("pickupDate",this.pickupDate);
    formData.append("rentDuration",this.rentDuration);
    formData.append("returnDate",this.returnDate);
    formData.append("vehicleNum",this.vehicleNum);
    formData.append("customerId",this.customerId);
    formData.append("driverId",this.selectDriverOption);

    this.bookingService.sendBooking(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      console.log(data)
      // this.rentReqService.removeReq(this.rentReqnewId);
      this.loadRequest();
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Saved UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })

  }
}
