import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Login } from './login/login';
import { Users } from './users/users';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    App,
    Login,
    Users
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // Add forms module features to my app module
    ReactiveFormsModule, // <--- needed for FormGroup, FormControl...
    FormsModule // <--- needed for ngModel
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideHttpClient()
  ],
  bootstrap: [App]
})
export class AppModule { }
