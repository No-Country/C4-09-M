import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchReportesComponent } from './merch-reportes.component';

describe('MerchReportesComponent', () => {
  let component: MerchReportesComponent;
  let fixture: ComponentFixture<MerchReportesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchReportesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchReportesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
