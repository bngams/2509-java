
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.scss',
  // imports: [
  //   // Add forms module features to my login component
  //   FormsModule
  // ]
})
export class Login {
  public loginForm = new FormGroup({
    email: new FormControl(''),
    pwd: new FormControl('')
  });

  // Should be in a specific Service class
  // <-> like @Autowired in Spring
  private httpClient = inject(HttpClient);

  // <-> injection via constructor
  // public Login(private httpClient: HttpClient) {}

  onSubmit(): void {
    console.log(this.loginForm.value);
    this.httpClient.post('http://localhost:8080/api/v1/auth', this.loginForm.value)
      .subscribe({
        next: (response) => {
          console.log('Login successful', response);
          localStorage.setItem('token', (response as any).tokenValue);
        },
        error: (error) => {
          console.error('There was an error!', error);
        }
      });
  }
}
