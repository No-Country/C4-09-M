import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsuarioModificarComponent } from './admin-usuario-modificar.component';

describe('AdminUsuarioModificarComponent', () => {
  let component: AdminUsuarioModificarComponent;
  let fixture: ComponentFixture<AdminUsuarioModificarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminUsuarioModificarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUsuarioModificarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
