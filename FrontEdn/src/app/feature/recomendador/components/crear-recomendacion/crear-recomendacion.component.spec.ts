import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearRecomendacionComponent } from './crear-recomendacion.component';

describe('CrearRecomendacionComponent', () => {
  let component: CrearRecomendacionComponent;
  let fixture: ComponentFixture<CrearRecomendacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearRecomendacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearRecomendacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
