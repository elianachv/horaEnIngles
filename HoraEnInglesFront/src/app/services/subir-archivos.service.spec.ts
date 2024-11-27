import { TestBed } from '@angular/core/testing';

import { SubirArchivosService } from './subir-archivos.service';

describe('SubirArchivosService', () => {
  let service: SubirArchivosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubirArchivosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
