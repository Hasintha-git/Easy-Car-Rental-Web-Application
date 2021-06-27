import { Component, OnInit } from '@angular/core';
import {BookingServiceService} from "../../../../service/booking-service.service";

@Component({
  selector: 'app-rented-vehicle-page-component',
  templateUrl: './rented-vehicle-page-component.component.html',
  styleUrls: ['./rented-vehicle-page-component.component.scss']
})
export class RentedVehiclePageComponentComponent implements OnInit {
  currentData:Array<any>=[];


  constructor(private bookingService:BookingServiceService) { }

  ngOnInit(): void {
    this.loadVehicle();
  }

  loadVehicle() {
    this.bookingService.getBooking().subscribe(data=>{
      this.currentData=data.data;
    })
  }
}
