import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class LogInServiceService {
  private baseURL="http://localhost:8080/login";
  constructor(private httpClient:HttpClient) {

  }

  signUp(formData: FormData):Observable<object>{
    return this.httpClient.post(this.baseURL,formData);
  }

  signIn(userName: string):Observable<any>{
    return this.httpClient.get(`${this.baseURL}/${userName}`);
  }

}
