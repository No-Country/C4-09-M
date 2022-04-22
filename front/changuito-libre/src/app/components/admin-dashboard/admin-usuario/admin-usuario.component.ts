import { Client } from './../../../model/client';
import { AdminService } from './../../../services/admin.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-usuario',
  templateUrl: './admin-usuario.component.html',
  styleUrls: ['./admin-usuario.component.css']
})
export class AdminUsuarioComponent implements OnInit {

  clients: Client[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.adminService.getClients().subscribe(
      data => {
        this.clients = data;
      }
    );
  }

}
