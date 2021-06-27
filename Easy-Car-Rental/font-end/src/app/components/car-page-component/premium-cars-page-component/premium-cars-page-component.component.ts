import { Component, OnInit } from '@angular/core';
import {CarServiceService} from "../../../../service/car-service.service";
import {SharedServiceService} from "../../../../service/shared-service.service";

@Component({
  selector: 'app-premium-cars-page-component',
  templateUrl: './premium-cars-page-component.component.html',
  styleUrls: ['./premium-cars-page-component.component.scss']
})
export class PremiumCarsPageComponentComponent implements OnInit {
  currentData:Array<any>=[];
  constructor(private carServiceService :CarServiceService,private sharedService:SharedServiceService) {
    this.getCarDetails();
  }
  ngOnInit(): void {
  }

  getCarDetails(){
    this.carServiceService.getGenaralType("premium").subscribe(data=>{
      console.log(data)
      this.currentData=data.data;
      console.log(data)
    });
  }

  GopurchaseOrder(vehicleNum: any, currentKm: any, dailyPrice: any, monthPrice: any, carName: any) {
    this.sharedService.setMessage(vehicleNum,currentKm,dailyPrice,monthPrice,carName);
  }
}
