import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchProductsComponent } from './merch-products.component';

describe('MerchProductsComponent', () => {
  let component: MerchProductsComponent;
  let fixture: ComponentFixture<MerchProductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchProductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
