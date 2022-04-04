import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchProductoModificarComponent } from './merch-producto-modificar.component';

describe('MerchProductoModificarComponent', () => {
  let component: MerchProductoModificarComponent;
  let fixture: ComponentFixture<MerchProductoModificarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchProductoModificarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchProductoModificarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
