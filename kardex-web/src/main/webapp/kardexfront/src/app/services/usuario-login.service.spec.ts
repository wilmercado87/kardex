import { TestBed, inject } from '@angular/core/testing';

import { UsuarioLoginService } from './usuario-login.service';

describe('UsuarioLoginService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UsuarioLoginService]
    });
  });

  it('should be created', inject([UsuarioLoginService], (service: UsuarioLoginService) => {
    expect(service).toBeTruthy();
  }));
});
