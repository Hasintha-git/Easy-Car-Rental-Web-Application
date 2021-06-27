import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {Customer} from "../../../../dto/Customer";
import {CustomerServiceService}from "../../../../service/customer-service.service"
import Swal from "sweetalert2";

@Component({
  selector: 'app-customer-details-add-page-component',
  templateUrl: './customer-details-add-page-component.component.html',
  styleUrls: ['./customer-details-add-page-component.component.scss']
})
export class CustomerDetailsAddPageComponentComponent implements OnInit {
  customers:Customer=new Customer();
  customernName: any|undefined;
  customerId: any|undefined;
  address: any|undefined;
  contact: any|undefined;
  selectedFileNic: any | undefined;
  selectedFileLisson: any | undefined;

  constructor(private customerService:CustomerServiceService) { }

  ngOnInit(): void {
  }


  onSubmit(f: NgForm) {
    this.customers.customerId = f.value.customerId;
    this.customers.customernName = f.value.customernName;
    this.customers.address = f.value.address;
    this.customers.contact = f.value.contact;

    console.log(this.customers.customerId, this.customers.address);
    let formData = new FormData();
    formData.append("nicImg",this.selectedFileNic,this.selectedFileNic.name);
    formData.append("drivingImg",this.selectedFileLisson,this.selectedFileLisson.name);
    formData.append("customerId",this.customers.customerId);
    formData.append("customerName",this.customers.customernName);
    formData.append("address",this.customers.address);
    formData.append("contact",this.customers.contact);


    console.log(formData.toString());

    this.customerService.submitCustomerdetails(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Submit Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      console.log(data)
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Submit UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    });
  }

  lissonImg(event: any) {
    this.selectedFileLisson=<File> event.target.files[0];
  }

  nicImg(event: any) {
    this.selectedFileNic=event.target.files[0];
  }

}
