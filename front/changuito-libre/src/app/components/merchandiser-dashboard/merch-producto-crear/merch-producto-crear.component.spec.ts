import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchProductoCrearComponent } from './merch-producto-crear.component';

describe('MerchProductoCrearComponent', () => {
  let component: MerchProductoCrearComponent;
  let fixture: ComponentFixture<MerchProductoCrearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchProductoCrearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchProductoCrearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
