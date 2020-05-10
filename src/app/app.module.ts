import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { MyServiceService } from './my-service.service';
import { LoanacceptedComponent } from './loanaccepted/loanaccepted.component';
import { LoanapprovedComponent } from './loanapproved/loanapproved.component';
import { LoanrejectedComponent } from './loanrejected/loanrejected.component';

@NgModule({
  declarations: [
    AppComponent,
    LoanrequestComponent,
    LoanacceptedComponent,
    LoanapprovedComponent,
    LoanrejectedComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule,FormsModule
  ],
  providers: [MyServiceService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
