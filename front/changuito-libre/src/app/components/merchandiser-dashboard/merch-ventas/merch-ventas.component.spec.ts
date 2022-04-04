import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchVentasComponent } from './merch-ventas.component';

describe('MerchVentasComponent', () => {
  let component: MerchVentasComponent;
  let fixture: ComponentFixture<MerchVentasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchVentasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchVentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
