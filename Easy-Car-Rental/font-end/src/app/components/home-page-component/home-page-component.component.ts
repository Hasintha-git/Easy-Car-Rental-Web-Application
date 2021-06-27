import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-home-page-component',
  templateUrl: './home-page-component.component.html',
  styleUrls: ['./home-page-component.component.scss']
})
export class HomePageComponentComponent implements OnInit {

  constructor() { }

  image: string | undefined;
  luxury: string|undefined;
  ngOnInit(): void {
    // let image = "F:\\2 nd semester lesson via online Rec\\2021.3.29\\Spring final project\\car-rental-system\\src\\assets\\admin page img\\car-1.png";
    this.luxury="/cars/luxury-cars";
  }


}
