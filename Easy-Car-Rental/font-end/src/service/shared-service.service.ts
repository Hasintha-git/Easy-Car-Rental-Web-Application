import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {
  // @ts-ignore
  vehicleNum:string;
  // @ts-ignore
  currentKm:string;
  // @ts-ignore
  dailyPrice:string;
  // @ts-ignore
  monthPrice:string;
  // @ts-ignore
  carName:string;
  // @ts-ignore
  userName: string;




  constructor() { }
  setMessage(vehicleNum:string,currentKm:string,dailyPrice:string,monthPrice:string,carName:string){
    this.vehicleNum=vehicleNum;
    this.currentKm=currentKm;
    this.dailyPrice=dailyPrice;
    this.monthPrice=monthPrice;
    this.carName=carName;

  }


  setUserName(userName:string){
    this.userName=userName;
  }
  getUserName(){
    return this.userName;
  }
  getVehicleNum(){
    return this.vehicleNum;
  }
  getCurrentKm(){
    return this.currentKm;
  }
  getDailyPrice(){
    return this.dailyPrice;
  }
  getMonthPrice(){
    return this.monthPrice;
  }
  getCarName(){
    return this.carName;
  }
}
