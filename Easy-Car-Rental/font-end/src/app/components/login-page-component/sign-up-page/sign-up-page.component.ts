import { Component, OnInit } from '@angular/core';
import {LogInServiceService} from "../../../../service/log-in-service.service";
import Swal from "sweetalert2";
@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.scss']
})
export class SignUpPageComponent implements OnInit {
  role: any;
  userName: any;
  password: any;
  NIC: any;
  address: any;
  eMail: any;

  constructor(private loginService:LogInServiceService) { }

  ngOnInit(): void {
  }


  onSubmit(f: any) {
    let formData = new FormData();
    formData.append("userName",this.userName);
    formData.append("password",this.password);
    formData.append("role",this.role);
    formData.append("email",this.eMail);
    formData.append("nic",this.NIC);
    formData.append("address",this.address);

    this.loginService.signUp(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
    });

  }
}
