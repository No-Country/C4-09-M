import { TokenStorageService } from './../../services/token-storage.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-perfil-usuario',
  templateUrl: './perfil-usuario.component.html',
  styleUrls: ['./perfil-usuario.component.css']
})
export class PerfilUsuarioComponent implements OnInit {

  currentUser: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {

      this.currentUser = this.token.getUser();

  }

}
