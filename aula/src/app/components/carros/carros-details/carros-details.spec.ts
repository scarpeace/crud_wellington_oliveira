import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrosDetails } from './carros-details';

describe('CarrosDetails', () => {
  let component: CarrosDetails;
  let fixture: ComponentFixture<CarrosDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarrosDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrosDetails);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
