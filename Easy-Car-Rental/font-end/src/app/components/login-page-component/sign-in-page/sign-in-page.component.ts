import {Component, OnInit} from '@angular/core';
import {LogInServiceService} from "../../../../service/log-in-service.service";
import Swal from "sweetalert2";
import {Router} from "@angular/router";
import {SharedServiceService} from "../../../../service/shared-service.service";

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.scss']
})
export class SignInPageComponent implements OnInit {
  selectedRouter: string | undefined;
  userName: any;
  password: any;
  password1: number | undefined;
  password2: number | undefined;

  constructor(private loginService: LogInServiceService, private router: Router,private shared:SharedServiceService) {
  }

  ngOnInit(): void {
    // this.selectedRouter="/booking";
    // this.selectedRouter="/admin/dashboard";
    // this.selectedRouter="/driver";

  }

  onSubmit(f: any) {
    console.log(this.userName);
    this.shared.setUserName(this.userName);
    this.loginService.signIn(this.userName).subscribe(data => {
      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })

      console.log(this.password);
      console.log(data.data[0].password);
      if (this.password === "19999") {
        console.log(data.data[0].role);
        if (data.data[0].role === "Admin") {
          this.router.navigate(['/admin/dashboard'])
          this.selectedRouter = "/admin/dashboard";

        } else if (data.data[0].role === "driver") {
          this.router.navigate(['/driver'])
          this.selectedRouter = "/driver";
        } else {
          this.router.navigate(['/booking'])
          this.selectedRouter = "/booking";
        }

        console.log(this.selectedRouter);
      }

    })
  }
}
