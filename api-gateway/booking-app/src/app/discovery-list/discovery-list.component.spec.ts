import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscoveryListComponent } from './discovery-list.component';

describe('DiscoveryListComponent', () => {
  let component: DiscoveryListComponent;
  let fixture: ComponentFixture<DiscoveryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscoveryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscoveryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
