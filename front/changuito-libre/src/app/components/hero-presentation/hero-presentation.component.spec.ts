import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroPresentationComponent } from './hero-presentation.component';

describe('HeroPresentationComponent', () => {
  let component: HeroPresentationComponent;
  let fixture: ComponentFixture<HeroPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeroPresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
