import { Component, OnInit } from '@angular/core';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {

  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }

  isLoggedIn() {
    return this.authService.isAuthenticated();
  }

  getProfile() {
    console.log(this.authService.getIdToken());
    return this.authService.getIdToken().given_name + ' ' + this.authService.getIdToken().family_name;
  }

  canSeeRatings() {
    return this.authService.hasPermission('view:rated:books');
  }
}
