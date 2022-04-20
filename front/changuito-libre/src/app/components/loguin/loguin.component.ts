import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loguin',
  templateUrl: './loguin.component.html',
  styleUrls: ['./loguin.component.css']
})
export class LoguinComponent implements OnInit {

  username?: string;
  password?: string;
  messages: any;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }


}
