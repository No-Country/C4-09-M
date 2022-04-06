import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsuariosRegistradosComponent } from './admin-usuarios-registrados.component';

describe('AdminUsuariosRegistradosComponent', () => {
  let component: AdminUsuariosRegistradosComponent;
  let fixture: ComponentFixture<AdminUsuariosRegistradosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminUsuariosRegistradosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUsuariosRegistradosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
