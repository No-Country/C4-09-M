import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchSideBarComponent } from './merch-side-bar.component';

describe('MerchSideBarComponent', () => {
  let component: MerchSideBarComponent;
  let fixture: ComponentFixture<MerchSideBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchSideBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
