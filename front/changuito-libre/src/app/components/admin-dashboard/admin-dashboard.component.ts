import { User } from './../../model/user';
import { Merch } from './../../model/merch';
import { UserService } from './../../services/user.service';
import { MerchService } from './../../services/merch.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  content!: string;
  merchandisers!: Merch[];
  users!: User[];

  constructor(private merchSerice: MerchService, private userService: UserService) { }

  ngOnInit(): void {
  }

}
