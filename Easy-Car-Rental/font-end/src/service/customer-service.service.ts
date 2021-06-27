import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private baseURL="http://localhost:8080/customer";
  private baseURL2="http://localhost:8080/customer/findName";
  constructor(private httpClient:HttpClient) {

  }

  submitCustomerdetails(formData: FormData):Observable<object>{
    return this.httpClient.post(this.baseURL,formData);
  }
  findCustomer(userName:string):Observable<object>{
    return this.httpClient.get(`${this.baseURL2}/${userName}`);
  }

}
