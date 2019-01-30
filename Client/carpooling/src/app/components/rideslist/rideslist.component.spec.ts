import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RideslistComponent } from './rideslist.component';

describe('RideslistComponent', () => {
  let component: RideslistComponent;
  let fixture: ComponentFixture<RideslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RideslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RideslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
