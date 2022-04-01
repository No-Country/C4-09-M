import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchandiserDashboardComponent } from './merchandiser-dashboard.component';

describe('MerchandiserDashboardComponent', () => {
  let component: MerchandiserDashboardComponent;
  let fixture: ComponentFixture<MerchandiserDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MerchandiserDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchandiserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
