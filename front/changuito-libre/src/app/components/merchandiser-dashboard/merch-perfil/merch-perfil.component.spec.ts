import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchPerfilComponent } from './merch-perfil.component';

describe('MerchPerfilComponent', () => {
  let component: MerchPerfilComponent;
  let fixture: ComponentFixture<MerchPerfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchPerfilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
