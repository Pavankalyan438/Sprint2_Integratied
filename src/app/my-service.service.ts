import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyServiceService {
  
  

  updateBal(updatebal: LoanDisbursal):any {
   const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post("http://localhost:1004/update/updateBal", updatebal,  { headers,responseType: 'text'});
  }
 
  getRequestsInitially(): Observable<LoanRequests[]> {
    //this function runs for first time
    return this.httpService.get<LoanRequests[]>("http://localhost:1005/loan/getAllRequests");
  }
  

  
  getApprovesInitially(): Observable<LoanDisbursal[]> {
    //this function runs for first time
    return this.httpService.get<LoanDisbursal[]>("http://localhost:1001/loan/approvedrequests");
  }
 

  
  getRejectsInitially(): Observable<LoanDisbursal[]> {
    //this function runs for first time
    return this.httpService.get<LoanDisbursal[]>("http://localhost:1003/loan/allreqrejects");
  }
 

  loanRequest(user: LoanRequests):any{
    
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.post("http://localhost:1000/loan/request", user,  {headers, responseType: 'text'});
  }

  constructor(private httpService: HttpClient) { }
}

export class LoanRequests {
 
    
    public accountId: string;
   public loanAmount : number;
   public loanTenure: number;
   public creditScore: number;
   public loanRoi: number;
   public loanStatus='Pending';
   public loanType: string;
   public loanId:number;
   
   
 }
 export class LoanDisbursal {
  constructor(
    
    public accountId: string,
   public loanAmount : number,
   public loanTenure: number,
   public creditScore: number,
   public loanRoi: number,
   public loanStatus: string,
   public loanType: string,
   public emi: number,
   public loanId:number){}
 }
