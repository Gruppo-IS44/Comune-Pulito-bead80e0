import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegnalazioneComponent } from './segnalazione.component';

describe('SegnalazioneComponent', () => {
  let component: SegnalazioneComponent;
  let fixture: ComponentFixture<SegnalazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SegnalazioneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SegnalazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
