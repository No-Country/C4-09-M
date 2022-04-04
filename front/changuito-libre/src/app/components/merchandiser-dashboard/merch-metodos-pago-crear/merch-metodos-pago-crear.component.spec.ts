import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchMetodosPagoCrearComponent } from './merch-metodos-pago-crear.component';

describe('MerchMetodosPagoCrearComponent', () => {
  let component: MerchMetodosPagoCrearComponent;
  let fixture: ComponentFixture<MerchMetodosPagoCrearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchMetodosPagoCrearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchMetodosPagoCrearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
