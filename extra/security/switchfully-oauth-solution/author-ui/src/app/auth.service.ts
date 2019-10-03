import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import * as auth0 from 'auth0-js';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  auth0 = new auth0.WebAuth({
    clientID: 'EubZo39VH5OMqngALNs49S4Coi2MV5Ug',
    domain: 'nielsjani.eu.auth0.com',
    responseType: 'token id_token',
    audience: 'http://localhost:4445',
    redirectUri: 'http://localhost:4200/callback',
    scope: 'openid profile create:book rate:book view:rated:books'
  });

  constructor(public router: Router) {
  }

  public login(): void {
    this.auth0.authorize();
  }

  public handleAuthentication(): void {
    this.auth0.parseHash((err, authResult) => {
      if (authResult && authResult.accessToken && authResult.idToken) {
        window.location.hash = '';
        this.setSession(authResult);
        this.router.navigate(['/']);
      } else if (err) {
        this.router.navigate(['/']);
        console.log(err);
      }
    });
  }

  private setSession(authResult): void {
    // Set the time that the access token will expire at
    const expiresAt = JSON.stringify((authResult.expiresIn * 1000) + new Date().getTime());
    localStorage.setItem('access_token', authResult.accessToken);
    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem('expires_at', expiresAt);
  }

  public logout(): void {
    // Remove tokens and expiry time from localStorage
    localStorage.removeItem('access_token');
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
    // Go back to the home route
    this.router.navigate(['/']);
  }

  public isAuthenticated(): boolean {
    // Check whether the current time is past the
    // access token's expiry time
    const expiresAt = JSON.parse(localStorage.getItem('expires_at'));
    return new Date().getTime() < expiresAt;
  }

  public getIdToken() {
    if (this.isAuthenticated()) {
      return this.parseJwt(localStorage.getItem('id_token'));
    } else {
      return {};
    }
  }

  private getAccessToken() {
    if (this.isAuthenticated()) {
      return this.parseJwt(localStorage.getItem('access_token'));
    } else {
      return {};
    }
  }

  parseJwt(token) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
  }

  hasPermission(permissionName: string) {
    return this.isAuthenticated() && this.getAccessToken() && this.getAccessToken().scope.indexOf(permissionName) > -1;
  }

}
