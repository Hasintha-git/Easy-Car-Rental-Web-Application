import { Component, OnInit } from '@angular/core';
import {DriverServiceService} from "../../../../service/driver-service.service";
import {MatDialog} from "@angular/material/dialog";
import {CarAddPageComponentComponent} from "../car-manage-page-component/car-add-page-component/car-add-page-component.component";
import {DriverManagePageComponentComponent} from "../driver-manage-page-component/driver-manage-page-component.component";
import Swal from "sweetalert2";
import {SharedServiceService} from "../../../../service/shared-service.service";

@Component({
  selector: 'app-driver-view-page-component',
  templateUrl: './driver-view-page-component.component.html',
  styleUrls: ['./driver-view-page-component.component.scss']
})
export class DriverViewPageComponentComponent implements OnInit {

  currentData:Array<any>=[];
  constructor(private driverService:DriverServiceService,public dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.loadDrivers();
  }

  AddNewDriver() {
    let matDialogRef = this.dialog.open(DriverManagePageComponentComponent,{
      width: '80%',
      panelClass: 'my-class',
      backdropClass: 'backdropBackground',
    });
    matDialogRef.afterClosed().subscribe(result=>{
        this.loadDrivers()
    })
  }


  updateDriver(row:any) {
    let matDialogRef = this.dialog.open(DriverManagePageComponentComponent,{
      width: '80%',
      panelClass: 'my-class',
      backdropClass: 'backdropBackground',
      data:row,

    });
    this.loadDrivers()
  }

  clickdriverId:any;
  removeDriver(row:any) {
    this.clickdriverId=row.driverId;
    this.driverService.deleteDrivers(this.clickdriverId).subscribe(data=>{
      Swal.fire({
        title: 'Success!',
        text: 'Submit Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      this.loadDrivers()
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

  loadDrivers() {
      this.driverService.getAllDrivers().subscribe(data=>{
        this.currentData=data.data;
      })
  }


}
