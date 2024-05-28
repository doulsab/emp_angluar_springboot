import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Import FormsModule for ngModel
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {
  provideHttpClient,
  withInterceptorsFromDi,
} from '@angular/common/http';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';

@NgModule({
  declarations: [AppComponent, EmployeeListComponent, CreateEmployeeComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule], // Add FormsModule here
  providers: [provideHttpClient(withInterceptorsFromDi())],
  bootstrap: [AppComponent],
})
export class AppModule {}
