import {Component, Inject, OnInit} from '@angular/core';
import {DriverServiceService} from "../../../../service/driver-service.service";
import {Driver} from "../../../../dto/Driver";
import Swal from "sweetalert2";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CarViewPageComponentComponent} from "../car-view-page-component/car-view-page-component.component";
import {DriverViewPageComponentComponent} from "../driver-view-page-component/driver-view-page-component.component";

@Component({
  selector: 'app-driver-manage-page-component',
  templateUrl: './driver-manage-page-component.component.html',
  styleUrls: ['./driver-manage-page-component.component.scss']
})
export class DriverManagePageComponentComponent implements OnInit {
  driver:Driver=new Driver();
  driverId: any;
  name: any;
  address: any;
  contact: any;


  recievedRow: any;

  constructor(private driverService:DriverServiceService,public dialogRef:MatDialogRef<DriverViewPageComponentComponent>,@Inject(MAT_DIALOG_DATA)public data:any) {
    this.recievedRow=data
    if(this.recievedRow!=null){
      this.driverId=this.recievedRow.driverId;
      this.name=this.recievedRow.name;
      this.address=this.recievedRow.address;
      this.contact=this.recievedRow.contact;
    }
  }

  ngOnInit(): void {
  }

  onSubmit() {
    let formData = new FormData();
    this.driverId="1";
    formData.append("driverId",this.driverId);
    formData.append("name",this.name);
    formData.append("address",this.address);
    formData.append("conatct",this.contact);

    this.driverService.addDriver(formData).subscribe(data=>{
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
    })
  }

  updateDriver() {
    let formData = new FormData();
    formData.append("driverId",this.driverId);
    formData.append("name",this.name);
    formData.append("address",this.address);
    formData.append("conatct",this.contact);

    this.driverService.updateDriver(formData).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Update Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      console.log(data)
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Update UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })

  }
}
