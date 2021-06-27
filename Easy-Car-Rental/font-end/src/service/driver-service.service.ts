import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class DriverServiceService {
  private driverUrl="http://localhost:8080/driving/postDriver";
  private getDriver="http://localhost:8080/driving";
  constructor(private httpClient:HttpClient) { }

  addDriver(formdata:FormData):Observable<object>{

    return this.httpClient.post(this.driverUrl,formdata);
  }
  updateDriver(formdata:FormData):Observable<object>{
    return this.httpClient.put(this.getDriver,formdata);
  }

  getAllDrivers():Observable<any>{
    return this.httpClient.get(this.getDriver);
  }
  deleteDrivers(driverId:string):Observable<any> {
    return this.httpClient.delete(`${this.getDriver}/${driverId}`);
  }
}
