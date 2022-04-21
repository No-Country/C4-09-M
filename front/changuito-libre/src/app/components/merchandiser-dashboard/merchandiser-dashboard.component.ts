import { UserService } from './../../services/user.service';
import { Content } from './../../model/content';
import { MerchService } from './../../services/merch.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-merchandiser-dashboard',
  templateUrl: './merchandiser-dashboard.component.html',
  styleUrls: ['./merchandiser-dashboard.component.css']
})
export class MerchandiserDashboardComponent implements OnInit {

    content!: string;

  constructor(private merchService: MerchService, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getMerchBoard().subscribe(
      (      data: string) => {
        this.content = data;
      }, (err: { error: string; }) => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
