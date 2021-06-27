import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {
  private baseURL="http://localhost:8080/cars";
  private getCarNumUrl="http://localhost:8080/cars/vehicleNum";
  private baseURL2="http://localhost:8080/cars/type";
  constructor(private httpClient:HttpClient) { }



  sendImgOnly(formData: FormData):Observable<object>{
    // let url=this.baseURL2+"/"+cars.vehicleNum+"/"+cars.brand+"/"+cars.type+"/"+cars.currentKm+"/"+cars.freeKmForDay+"/"+cars.freeKmForMonth+"/"+cars.monthPrice+"/"+cars.dailyPrice+"/"+cars.fuel+"/"+cars.transmission+"/"+cars.priceForKm+"/"+cars.color+"/"+cars.passenger;
    return this.httpClient.post(this.baseURL,formData);
  }

  loadAllVehicle():Observable<any>{
    return this.httpClient.get(this.baseURL+"/allcars");
  }

  updateVehicle(formData: FormData):Observable<object>{
    return this.httpClient.put(this.baseURL,formData);
  }


  removeCar(vehicleNum:string):Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${vehicleNum}`);
  }


  getGenaralType(general1: string):Observable<any> {
    return this.httpClient.get(`${this.baseURL2}/${general1}`);
  }

  findCar(vehicleNum:string):Observable<any>{
    return this.httpClient.get(`${this.getCarNumUrl}/${vehicleNum}`)
  }
}
