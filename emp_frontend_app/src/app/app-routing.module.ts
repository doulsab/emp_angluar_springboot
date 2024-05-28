import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';

// 2.Step define the routs properely.
const routes: Routes = [
  { path: 'employees', component: EmployeeListComponent }, // this is get employee list
  { path: '', redirectTo: '/employees', pathMatch: 'full' }, //empty redirection
  { path: 'create-employee', component: CreateEmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
