import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class RentedRequestServiceService {
  private baseURL="http://localhost:8080/rentalReq";
  constructor(private httpClient:HttpClient) { }

  sendRentedRequest(formData: FormData):Observable<object>{
    return this.httpClient.post(this.baseURL,formData);
  }

  getAllRequest():Observable<any>{
    return this.httpClient.get(this.baseURL);
  }

  removeReq(rentReqId:string):Observable<any>{
    return this.httpClient.delete(`${this.baseURL}/${rentReqId}`);
  }
}
