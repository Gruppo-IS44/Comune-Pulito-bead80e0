import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestoreComponent } from './gestore.component';

describe('GestoreComponent', () => {
  let component: GestoreComponent;
  let fixture: ComponentFixture<GestoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestoreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
