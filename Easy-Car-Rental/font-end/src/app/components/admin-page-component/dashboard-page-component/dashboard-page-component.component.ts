import { Component, OnInit } from '@angular/core';
import {GetCountServiceService} from "../../../../service/get-count-service.service";
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';

@Component({
  selector: 'app-dashboard-page-component',
  templateUrl: './dashboard-page-component.component.html',
  styleUrls: ['./dashboard-page-component.component.scss']
})
export class DashboardPageComponentComponent implements OnInit {
  reqCount: any;
  carsCount: any;
  customerCount: any;
  bookingCount: any;

  maximumDrivers:any=50;

  currentDrivers:any=5;

  public pieChartOptions: ChartOptions = {
    responsive: true,
  };


  constructor(private getCountService:GetCountServiceService) {
    this.getCountService.driverCount().subscribe(data=>{
      this.currentDrivers=data.data;
    })
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();

  }

  ngOnInit(): void {
    this.reqCounted();
    this.rentBookingCounted();
    this.rentCustomerCounted();
    this.rentVehicleCounted();

  }


  public pieChartLabels: Label[] = [['Maxium', 'Cars'], ['Current', 'Cars']];
  public pieChartData: SingleDataSet = [this.maximumDrivers, this.currentDrivers];
  public pieChartType: ChartType = 'doughnut';
  public pieChartLegend = true;
  public pieChartPlugins = [];

  public pieChartLabels2: Label[] = [['Maxium', 'Drivers'], ['Current', 'Drivers']];
  public pieChartData2: SingleDataSet = [this.maximumDrivers, this.currentDrivers];
  public pieChartType2: ChartType = 'doughnut';
  public pieChartLegend2 = true;
  public pieChartPlugins2 = [];
  reqCounted(){
    this.getCountService.reqCount().subscribe(data=>{
      this.reqCount=data.data;
    })
  }
  maxBooking:any=100000;
  bookingPrasentag: any;
  rentBookingCounted(){
    this.getCountService.bookingCount().subscribe(data=>{
      this.bookingCount=data.data;
      if (this.bookingCount <= this.maxBooking) {
        this.bookingPrasentag=this.bookingCount*2+"%";
      }
    })
  }
  maxCustomers:any=100000;
  customerPrasentag: any;
  rentCustomerCounted(){
    this.getCountService.customerCount().subscribe(data=>{
      this.customerCount=data.data;
      if (this.customerCount <= this.maxCustomers) {
        this.customerPrasentag=this.customerCount*2+"%";
      }
    })
  }
  maxCars:any=50;
  carPrasentag: any;



  rentVehicleCounted(){
    this.getCountService.vehicleCount().subscribe(data=>{
      this.carsCount=data.data;
      if (this.carsCount <= this.maxCars) {
        this.carPrasentag=this.carsCount*2+"%";
      }
    })
  }
}
