import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {
  private baseURL="http://localhost:8080/booking";
  constructor(private httpClient:HttpClient) { }

  sendBooking(formData: FormData):Observable<object>{
    return this.httpClient.post(this.baseURL,formData);
  }

  getBooking():Observable<any>{
    return this.httpClient.get(this.baseURL);
  }
}
