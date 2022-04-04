import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchPerfilModificarComponent } from './merch-perfil-modificar.component';

describe('MerchPerfilModificarComponent', () => {
  let component: MerchPerfilModificarComponent;
  let fixture: ComponentFixture<MerchPerfilModificarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchPerfilModificarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchPerfilModificarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
