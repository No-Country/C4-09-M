import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportsFormsViewComponent } from './reports-forms-view.component';

describe('ReportsFormsViewComponent', () => {
  let component: ReportsFormsViewComponent;
  let fixture: ComponentFixture<ReportsFormsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportsFormsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportsFormsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
