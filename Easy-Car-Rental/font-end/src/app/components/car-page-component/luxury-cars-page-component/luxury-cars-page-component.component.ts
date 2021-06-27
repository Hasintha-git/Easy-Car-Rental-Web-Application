import { Component, OnInit } from '@angular/core';
import {CarServiceService} from "../../../../service/car-service.service";
import {SharedServiceService} from "../../../../service/shared-service.service";

@Component({
  selector: 'app-luxury-cars-page-component',
  templateUrl: './luxury-cars-page-component.component.html',
  styleUrls: ['./luxury-cars-page-component.component.scss']
})
export class LuxuryCarsPageComponentComponent implements OnInit {
  currentData:Array<any>=[];
  constructor(private carServiceService :CarServiceService,private sharedService:SharedServiceService) {
    this.getCarDetails();
  }
  ngOnInit(): void {
  }

  getCarDetails(){
    this.carServiceService.getGenaralType("luxury").subscribe(data=>{
      console.log(data)
      this.currentData=data.data;
      console.log(data)
    });
  }

  GopurchaseOrder(vehicleNum: any, currentKm: any, dailyPrice: any, monthPrice: any, carName: any) {
    this.sharedService.setMessage(vehicleNum,currentKm,dailyPrice,monthPrice,carName);
  }
}
