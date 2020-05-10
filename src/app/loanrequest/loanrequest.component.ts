import { Component, OnInit } from '@angular/core';
import { LoanRequests, MyServiceService } from '../my-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loanrequest',
  templateUrl: './loanrequest.component.html',
  styleUrls: ['./loanrequest.component.css']
})
export class LoanrequestComponent implements OnInit {
  message: any;
  req: LoanRequests = new LoanRequests();
  

  constructor(private myservice: MyServiceService, private router: Router) { }
 loans=['Study Loan','Car Loan','House Loan']
  public loanRequest(): any {

    this.myservice.loanRequest(this.req).subscribe(data => {
      this.message = data
      this.router.navigate(['/loanreq']);
      alert(this.message);
    });
  }

  ngOnInit(): void {
  }

}
