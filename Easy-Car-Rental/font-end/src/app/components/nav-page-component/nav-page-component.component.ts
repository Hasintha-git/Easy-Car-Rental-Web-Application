import { Component, OnInit } from '@angular/core';
import {CustomerDetailsAddPageComponentComponent} from "../booking-page-component/customer-details-add-page-component/customer-details-add-page-component.component";
import {LoginPageComponentComponent} from "../login-page-component/login-page-component.component";
import {MatDialog} from "@angular/material/dialog";
;
@Component({
  selector: 'app-nav-page-component',
  templateUrl: './nav-page-component.component.html',
  styleUrls: ['./nav-page-component.component.scss']
})
export class NavPageComponentComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }



}
