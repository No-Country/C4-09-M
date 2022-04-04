import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchMetodosPagoComponent } from './merch-metodos-pago.component';

describe('MerchMetodosPagoComponent', () => {
  let component: MerchMetodosPagoComponent;
  let fixture: ComponentFixture<MerchMetodosPagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchMetodosPagoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchMetodosPagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
