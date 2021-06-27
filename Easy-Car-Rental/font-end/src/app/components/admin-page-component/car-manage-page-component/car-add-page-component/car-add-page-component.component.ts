import {Component, Inject, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Car} from "../../../../../dto/Car";
import {CarServiceService} from "../../../../../service/car-service.service";
import {error} from "@angular/compiler/src/util";
import {NgForm} from "@angular/forms";
import {ajaxGetJSON} from "rxjs/internal-compatibility";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {CarViewPageComponentComponent} from "../../car-view-page-component/car-view-page-component.component";

@Component({
  selector: 'app-car-add-page-component',
  templateUrl: './car-add-page-component.component.html',
  styleUrls: ['./car-add-page-component.component.scss']
})
export class CarAddPageComponentComponent implements OnInit {
  car: Car = new Car();
  vehicleNum: any;
  type: any;
  brand: any;
  passenger: any;
  color: any;
  freeKmForDay: any;
  freeKmForMonth: any;
  transmission: any;
  fuel: any;
  dailyPrice: any;
  monthPrice: any;
  currentKm: any;
  priceForKm: any;

  recievedRow: any;

  constructor(private carServiceService: CarServiceService,public dialogRef:MatDialogRef<CarViewPageComponentComponent>,@Inject(MAT_DIALOG_DATA)public data:any) {
    this.recievedRow=data;
    if(this.recievedRow!=null){
      this.vehicleNum=this.recievedRow.vehicleNum;
      this.type=this.recievedRow.type;
      this.brand=this.recievedRow.brand;
      this.passenger=this.recievedRow.passenger;
      this.color=this.recievedRow.color;
      this.freeKmForDay=this.recievedRow.kmForDay;
      this.freeKmForMonth=this.recievedRow.kmForMonth;
      this.transmission=this.recievedRow.transmission;
      this.fuel=this.recievedRow.fuel;
      this.dailyPrice=this.recievedRow.dailyPrice;
      this.monthPrice=this.recievedRow.monthPrice;
      this.currentKm=this.recievedRow.currentKm;
      this.priceForKm=this.recievedRow.priceForKm;
    }
  }


  ngOnInit(): void {

  }

  selectedFile: any | undefined;

  carChange({event}: { event: any }) {
    // if(event.event.target.files) {
    //   let fileReader = new FileReader();
    //   fileReader.readAsDataURL(event.event.target.files[0]);
    //   fileReader.onload = (event: any) => {
    //     this.url = event.target.result;
    //   }
    // }
    // this.url=event.event.target.result;
    this.selectedFile = <File>event.event.target.files[0];


  }

  onSubmit(form: NgForm) {
    console.log(form.value)

    this.car.vehicleNum = form.value.vehicleNum;
    this.car.brand = form.value.brand;
    this.car.type = form.value.type;
    this.car.passenger = form.value.passenger;
    this.car.color = form.value.color;
    this.car.priceForKm = form.value.priceForKm;
    this.car.transmission = form.value.transmission;
    this.car.fuel = form.value.fuel;
    this.car.dailyPrice = form.value.dailyPrice;
    this.car.monthPrice = form.value.monthPrice;
    this.car.freeKmForDay = form.value.freeKmForDay;
    this.car.freeKmForMonth = form.value.freeKmForMonth;
    this.car.currentKm = form.value.currentKm;

    console.log(this.car.vehicleNum, this.car.priceForKm);
    var formData = new FormData(), fd;
    formData.append('file', this.selectedFile, this.selectedFile.name)
    formData.append('vehicleNum', this.car.vehicleNum)
    formData.append('brand', this.car.brand)
    formData.append('type', this.car.type)
    formData.append('passenger', this.car.passenger)
    formData.append('color', this.car.color)
    formData.append('priceForKm', this.car.priceForKm)
    formData.append('transmission', this.car.transmission)
    formData.append('fuel', this.car.fuel)
    formData.append('dailyPrice', this.car.dailyPrice)
    formData.append('monthPrice', this.car.monthPrice)
    formData.append('freeKmForDay', this.car.freeKmForDay)
    formData.append('freeKmForMonth', this.car.freeKmForMonth)
    formData.append('currentKm', this.car.currentKm)




    // this.car.vehicleNum, this.car.passenger, this.car.color, this.car.priceForKm, this.car.transmission, this.car.fuel, this.car.dailyPrice, this.car.monthPrice, this.car.freeKmForDay, this.car.freeKmForMonth, this.car.currentKm, this.car.type, this.car.brand
    this.addNewVehicle(formData);

  }

  public addNewVehicle(formData: FormData){
    this.carServiceService.sendImgOnly(formData).subscribe(data => {

      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      console.log(data)
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Saved UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    });
  }

   public updateData(form: NgForm){
     this.car.vehicleNum = form.value.vehicleNum;
     this.car.brand = form.value.brand;
     this.car.type = form.value.type;
     this.car.passenger = form.value.passenger;
     this.car.color = form.value.color;
     this.car.priceForKm = form.value.priceForKm;
     this.car.transmission = form.value.transmission;
     this.car.fuel = form.value.fuel;
     this.car.dailyPrice = form.value.dailyPrice;
     this.car.monthPrice = form.value.monthPrice;
     this.car.freeKmForDay = form.value.freeKmForDay;
     this.car.freeKmForMonth = form.value.freeKmForMonth;
     this.car.currentKm = form.value.currentKm;

     console.log(this.car.vehicleNum, this.car.priceForKm);
     var formData = new FormData(), fd;
     formData.append('file', this.selectedFile, this.selectedFile.name)
     formData.append('vehicleNum', this.car.vehicleNum)
     formData.append('brand', this.car.brand)
     formData.append('type', this.car.type)
     formData.append('passenger', this.car.passenger)
     formData.append('color', this.car.color)
     formData.append('priceForKm', this.car.priceForKm)
     formData.append('transmission', this.car.transmission)
     formData.append('fuel', this.car.fuel)
     formData.append('dailyPrice', this.car.dailyPrice)
     formData.append('monthPrice', this.car.monthPrice)
     formData.append('freeKmForDay', this.car.freeKmForDay)
     formData.append('freeKmForMonth', this.car.freeKmForMonth)
     formData.append('currentKm', this.car.currentKm)



     this.updateVehicle(formData);


  }


  private updateVehicle(formData: FormData) {
    this.carServiceService.updateVehicle(formData).subscribe(data => {

      Swal.fire({
        title: 'Success!',
        text: 'Saved Success',
        icon: 'success',
        confirmButtonText: 'done'
      })
      console.log(data)
    }, error => {
      Swal.fire({
        title: 'Fails!',
        text: 'Saved UnSuccess',
        icon: 'error',
        confirmButtonText: 'done'
      })
    });
  }

}

