import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearBusquedaComponent } from './crear-busqueda.component';

describe('CrearBusquedaComponent', () => {
  let component: CrearBusquedaComponent;
  let fixture: ComponentFixture<CrearBusquedaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearBusquedaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearBusquedaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
