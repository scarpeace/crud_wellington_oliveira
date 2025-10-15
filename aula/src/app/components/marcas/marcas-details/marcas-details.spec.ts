import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarcasDetails } from './marcas-details';

describe('MarcasDetails', () => {
  let component: MarcasDetails;
  let fixture: ComponentFixture<MarcasDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MarcasDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MarcasDetails);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
