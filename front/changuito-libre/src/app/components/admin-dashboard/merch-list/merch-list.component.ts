import { Merch } from './../../../model/merch';
import { MerchService } from './../../../services/merch.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-merch-list',
  templateUrl: './merch-list.component.html',
  styleUrls: ['./merch-list.component.css']
})
export class MerchListComponent implements OnInit {

  merchs: Merch[] = [];

  constructor(private merchService:MerchService) { }

  ngOnInit(): void {
  }

}
