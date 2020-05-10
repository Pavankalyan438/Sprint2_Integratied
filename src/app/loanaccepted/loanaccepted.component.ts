import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyServiceService, LoanRequests } from '../my-service.service';

@Component({
  selector: 'app-loanaccepted',
  templateUrl: './loanaccepted.component.html',
  styleUrls: ['./loanaccepted.component.css']
})
export class LoanacceptedComponent implements OnInit {
  loanrequests:LoanRequests[];
  constructor(private myservice: MyServiceService,private router: Router) { }

  ngOnInit(): void {
    this.getAllRequests();
  }
  getAllRequests() {
    //adding loans or getting data of loans
    this.myservice.getRequestsInitially().subscribe((data)=>{this.loanrequests=data})
   
  }
}
