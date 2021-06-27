import { Component, OnInit } from '@angular/core';
import {CarServiceService} from "../../../../service/car-service.service";
import {SharedServiceService} from "../../../../service/shared-service.service";



@Component({
  selector: 'app-all-cars-page-component',
  templateUrl: './all-cars-page-component.component.html',
  styleUrls: ['./all-cars-page-component.component.scss']
})
export class AllCarsPageComponentComponent implements OnInit {
  // imgurl ="C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\add\\uploads/55555555.jpg";
  currentData:Array<any>=[];
  imgOne="https://images.pexels.com/photos/1149831/pexels-photo-1149831.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940";


  constructor(private carServiceService :CarServiceService,private sharedService:SharedServiceService) {
    this.getCarDetails();
  }

  ngOnInit(): void {


  }

  getCarDetails(){
    this.carServiceService.loadAllVehicle().subscribe(data=>{

      this.currentData=data.data;
      console.log(data)
    });
  }

  GopurchaseOrder(vehicleNum: string, currentKm: string, dailyPrice: string, monthPrice: string, carName: string) {

    this.sharedService.setMessage(vehicleNum,currentKm,dailyPrice,monthPrice,carName);
  }
}
