import {Component, OnInit} from '@angular/core';
import {CarServiceService} from "../../../../service/car-service.service";
import Swal from "sweetalert2";
import {CarAddPageComponentComponent} from "../car-manage-page-component/car-add-page-component/car-add-page-component.component";
import {MatDialog} from '@angular/material/dialog';
@Component({
  selector: 'app-car-view-page-component',
  templateUrl: './car-view-page-component.component.html',
  styleUrls: ['./car-view-page-component.component.scss']
})
export class CarViewPageComponentComponent implements OnInit{
  tblvehicleNum: string | undefined;
  currentData:Array<any>=[];

  constructor(private carServiceService: CarServiceService,public dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.loadVehicle()
    }


  loadVehicle() {
    this.carServiceService.loadAllVehicle().subscribe(data=>{
      // this.currentData=data;
      this.currentData=data.data;
      console.log(this.currentData)
      // console.log(data.data[1]);
      // console.log(data);
    })
  }

  AddNewCar() {
    let matDialogRef = this.dialog.open(CarAddPageComponentComponent,{
      width: '80%',
      panelClass: 'my-class',
      backdropClass: 'backdropBackground',


    });


  }

  updateCar(row: any) {

    let matDialogRef = this.dialog.open(CarAddPageComponentComponent,{
      width: '80%',
      panelClass: 'my-class',
      backdropClass: 'backdropBackground',
      data:row,
    });
    matDialogRef.afterClosed().subscribe(result=>{
      this.loadVehicle();
    })

  }
  vNum:any;
  removeCar(row: any) {
    this.vNum=row.vehicleNum;
    console.log(this.vNum)
    this.carServiceService.removeCar(this.vNum).subscribe(data=>{
      this.loadVehicle();
      Swal.fire({
        title: 'Success!',
        text: 'Added Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Added UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    })
  }
}
