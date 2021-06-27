import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GetCountServiceService {
  private bookingUrl="http://localhost:8080/booking/getCount";
  private carCountUrl="http://localhost:8080/cars/getCount";
  private customerCountUrl="http://localhost:8080/customer/getCount";
  private driverCountUrl="http://localhost:8080/driving/getCount";
  private payCountUrl="http://localhost:8080/pay/getCount";
  private reqCountUrl="http://localhost:8080/rentalReq/getCount";

  constructor(private httpClient:HttpClient) {

  }
  bookingCount():Observable<any>{
    return this.httpClient.get(this.bookingUrl);
  }
  vehicleCount():Observable<any>{
    return this.httpClient.get(this.carCountUrl);
  }
  customerCount():Observable<any>{
    return this.httpClient.get(this.customerCountUrl);
  }
  driverCount():Observable<any>{
    return this.httpClient.get(this.driverCountUrl);
  }
  payPriceCount():Observable<any>{
    return this.httpClient.get(this.payCountUrl);
  }
  reqCount():Observable<any>{
    return this.httpClient.get(this.reqCountUrl);
  }
}
