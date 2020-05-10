import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanacceptedComponent } from './loanaccepted.component';

describe('LoanacceptedComponent', () => {
  let component: LoanacceptedComponent;
  let fixture: ComponentFixture<LoanacceptedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoanacceptedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanacceptedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
