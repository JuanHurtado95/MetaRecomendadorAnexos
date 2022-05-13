import { TestBed } from '@angular/core/testing';

import { RecomendadorService } from './recomendador.service';

describe('RecomendadorService', () => {
  let service: RecomendadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecomendadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
