import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchNavComponent } from './merch-nav.component';

describe('MerchNavComponent', () => {
  let component: MerchNavComponent;
  let fixture: ComponentFixture<MerchNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
