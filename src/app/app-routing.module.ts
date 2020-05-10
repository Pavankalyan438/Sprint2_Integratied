import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { LoanacceptedComponent } from './loanaccepted/loanaccepted.component';
import { LoanapprovedComponent } from './loanapproved/loanapproved.component';
import { LoanrejectedComponent } from './loanrejected/loanrejected.component';


const routes: Routes = [{path: 'loanreq',component: LoanrequestComponent},
{path:'allloans',component:LoanacceptedComponent},
{path: 'acceptloans',component: LoanapprovedComponent},
{path: 'rejectloans',component: LoanrejectedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
