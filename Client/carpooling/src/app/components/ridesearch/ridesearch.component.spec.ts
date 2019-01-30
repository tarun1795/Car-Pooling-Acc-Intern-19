import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RidesearchComponent } from './ridesearch.component';

describe('RidesearchComponent', () => {
  let component: RidesearchComponent;
  let fixture: ComponentFixture<RidesearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RidesearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RidesearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
