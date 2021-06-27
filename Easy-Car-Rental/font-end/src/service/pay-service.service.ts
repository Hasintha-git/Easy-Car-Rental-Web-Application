import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class PayServiceService {
  private baseURL="http://localhost:8080/pay";
  constructor(private httpClient:HttpClient) {

  }

  addPay(formData:FormData):Observable<object>{
    return this.httpClient.post(this.baseURL,formData);
  }
}
